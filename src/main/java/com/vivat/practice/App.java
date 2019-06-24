package com.vivat.practice;

import com.vivat.practice.model.Detective;
import com.vivat.practice.model.Investigation;
import com.vivat.practice.model.LevelType;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {

    private static EntityManager entityManager;

    public static void main(String[] args) {

        //Let's create Entity Manager to do things with ORM
        EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("DetectivesPersistenceUnit");

        entityManager = entityManagerFactory.createEntityManager();

        // Cool, lets create and save first investigation
        entityManager.getTransaction().begin();
        Investigation whoKilledKennedy = new Investigation("Kennedy death", 1);
        entityManager.persist(whoKilledKennedy);
        entityManager.getTransaction().commit();


        // ok, one more
        entityManager.getTransaction().begin();
        Investigation whoKilledElvis = new Investigation("Elvis death", 1);
        entityManager.persist(whoKilledElvis);
        entityManager.getTransaction().commit();


        // lets find already created investigations by id, to make sure that we have them
        entityManager.getTransaction().begin();
        Investigation investigation = entityManager.find(Investigation.class, whoKilledKennedy.getId());

        System.out.println(investigation.toString());


        // Lets create detective and assign investigations
        Detective sherlok = new Detective("Sherlok", "Holmes", LevelType.PRO);

        sherlok.addInvestigation(whoKilledElvis);
        sherlok.addInvestigation(whoKilledKennedy);
        entityManager.persist(sherlok);
        entityManager.getTransaction().commit();


        // Aaaand print him out to the console
        entityManager.getTransaction().begin();

        Detective foundDetective = entityManager.find(Detective.class, sherlok.getId());

        System.out.println("Sherlok investigations:");
        foundDetective.getInvestigations()
            .forEach(x -> System.out.println(x.toString()));

        entityManager.getTransaction().commit();

    }


}
