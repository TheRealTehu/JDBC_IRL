package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorRepository {
    private final String DB_TYPE = "jdbc:postgresql";

    private final String HOST = "localhost";

    private final int PORT = 5432;

    private final String DB_NAME = "imdb_db";

    private final String URL = DB_TYPE + "://" + HOST + ":" + PORT + "/" + DB_NAME;

    private final String USER = "postgres";

    private final String PASS = "postgres";

    public List<Actor> getAllActors() {
        List<Actor> actors = new ArrayList<>();

        final String SQL = "SELECT id, name, birthday, death, biography FROM actors ORDER BY id ASC;";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement st = con.prepareStatement(SQL);

            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Actor actor = new Actor();
                actor.setId(rs.getInt(1));
                actor.setName(rs.getString(2));
                actor.setBirthday(rs.getDate("birthday"));
                actor.setDeath(rs.getDate("death"));
                actor.setBiography(rs.getString("biography"));

                actors.add(actor);
            }

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

        return actors;
    }

    public Actor getActorById(int id){
        final String SQL = "SELECT id, name, birthday, death, biography FROM actors WHERE id = ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement st = con.prepareStatement(SQL);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if(!rs.next()){
                return null;
            }

            Actor actor = new Actor();

            actor.setId(rs.getInt("id"));
            actor.setName(rs.getString("name"));
            actor.setBirthday(rs.getDate("birthday"));
            actor.setDeath(rs.getDate("death"));
            actor.setBiography(rs.getString("biography"));

            return actor;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addActor(Actor actor){
        final String SQL = "INSERT INTO actors(id, name, birthday, death, biography) VALUES (?,?,?,?,?);";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement st = con.prepareStatement(SQL);

            st.setInt(1, actor.getId());
            st.setString(2, actor.getName());
            st.setDate(3, actor.getBirthday());
            st.setDate(4, actor.getDeath());
            st.setString(5, actor.getBiography());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateActor(int id, Actor actor){
        final String SQL = "UPDATE actors SET name = ?, birthday = ?, death = ?, biography = ? WHERE id = ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement st = con.prepareStatement(SQL);

            st.setString(1, actor.getName());
            st.setDate(2, actor.getBirthday());
            st.setDate(3, actor.getDeath());
            st.setString(4, actor.getBiography());
            st.setInt(5, actor.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteActor(int id){
        final String SQL = "DELETE FROM actors WHERE id = ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement st = con.prepareStatement(SQL);

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
