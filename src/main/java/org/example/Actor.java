package org.example;

import java.sql.Date;

public class Actor {
    private int id;
    private String name;
    private Date birthday;
    private Date death;
    private String biography;

    public Actor() {
    }

    public Actor(int id, String name, Date birthday, Date death, String biography) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.death = death;
        this.biography = biography;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Actor " +
                "id = " + id +
                ", name = " + name +
                ", birthday = " + birthday +
                ", death = " + death +
                ", biography = " + biography;
    }
}
