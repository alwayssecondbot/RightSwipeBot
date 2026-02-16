import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.RollbackException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import ru.yanes.Car.parts.entity.Country;
import ru.yanes.controller.Postgres;

import java.util.Set;

@Slf4j
public class AppTest {
    Postgres postgres = new Postgres();

    @Test
    public void wouldStartHibernate(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoGeek");
        EntityManager em = emf.createEntityManager();
    }

    @Test
    public void dropDB() {
        postgres.dropDB();
    }
    @Test
    public void createDB() {
        postgres.initiateDB();
    }

    @Test
    public void populateDB() {
        postgres.populateDB();
    }

    @Test
    public void validateInsertions(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Country country = Country.builder().
                code("123").
                name("Jopa").
                alpha2("TR").
                alpha3("TRG").
                build();

        Set<ConstraintViolation<Country>> violationSet = validator.validate(country);
        if (violationSet.isEmpty()) {

            try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cars")) {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
                em.close();
            } catch (RollbackException e) {
                log.error("There is an error:", e);
            }
        } else {
            System.out.println("Invalid data found");
            for (ConstraintViolation<Country> violation : violationSet) {
                System.out.println(violation.getMessage());
            }
        }
    }

}
