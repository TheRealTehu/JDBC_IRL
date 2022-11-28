package org.example;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ActorRepository actorRepository = new ActorRepository();

        //actorRepository.getAllActors().forEach(System.out::println);

        //System.out.println(actorRepository.getActorById(916289));

//        actorRepository.addActor(new Actor(999999, "Name Name", Date.valueOf(LocalDate.now()),
//                Date.valueOf(LocalDate.now()), "Interesting"));
//
//        System.out.println(actorRepository.getActorById(999999));

//        actorRepository.updateActor(999999, new Actor(999999, "Namer Boi", Date.valueOf(LocalDate.now()),
//                Date.valueOf(LocalDate.now()), "Wooow"));
//
//        System.out.println(actorRepository.getActorById(999999));

        actorRepository.deleteActor(999999);

        System.out.println(actorRepository.getActorById(999999));
    }
}