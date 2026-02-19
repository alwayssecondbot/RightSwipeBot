import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.RollbackException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;
import ru.yanes.Car.parts.entity.Country;
import ru.yanes.config.Config;
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
    public void configArgsNotNull() throws Exception {
        Config config = new Config();
        String message = "";
        if (config.getSupportChatId() == null) {
            message+="- Support chat id;\n";
        }
        if (config.getAdminChatId() == null) {
            message+="- Admin chat id;\n";
        }
        if (config.getName() == null){
            message+="- Bot name;\n";
        }
        if (config.getPath() == null){
            message+="- Bot path;\n";
        }
        if (config.getVersion() == null){
            message+="- Bot version;\n";
        }
        if (config.getUri() == null){
            message+="- Bot uri;\n";
        }
        if (config.getToken() == null){
            message+="- Bot token;\n";
        }

        if (!message.isEmpty()){
            throw new Exception("One or more fields is null:\n"+message);
        }

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
