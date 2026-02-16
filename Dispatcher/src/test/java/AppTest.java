package java;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.testng.annotations.Test;

import ru.yanes.Car.Parts.Entity.Country;

public class AppTest {

    @Test
    public void wouldStartHibernate(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cars");
        EntityManager em = emf.createEntityManager();
    }

//    @Test
//    public void everyValue() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cars");
//        EntityManager em = emf.createEntityManager();
//
//        Country empty_country = new Country();
//        empty_country.builder().
//                code("").
//                name("").
//                alpha2("").
//                alpha3("").
//                build();
//
//        em.getTransaction();
//        em.getTransaction().begin();
//        em.persist(empty_country);
//        em.getTransaction().commit();
//        em.close();
//    }
}
