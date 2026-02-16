package ru.yanes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import lombok.extern.slf4j.Slf4j;
import ru.yanes.Car.Parts.Entity.Country;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

@Slf4j
class RightSwipeBot{
    public static void main(String[] args) {
        fixSystemOutEncoding();
//        System.out.print("Set car's weight, height and width: ");
//        short[] bodyChars = new short[3];
//        for (int i = 0; i < 3; i++){
//            bodyChars[i]=in.nextShort();
//        }
//        in.close();

        try (Scanner scanner = new Scanner(System.in)) {
            Postgres postgres = new Postgres();

            System.out.print("Select action: 1 - create, 2 - drop: ");
            short answer = scanner.nextShort();
            switch (answer) {
                case 1 -> {
                    postgres.initiateDB();
                    postgres.populateDB();
                }
                case 2 -> postgres.dropDB();
                default -> throw new IllegalArgumentException("Variant '" + answer + "' doesn't exist");

            }
        }
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

    private static void fixSystemOutEncoding() {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new java.io.PrintStream(System.err, true, StandardCharsets.UTF_8));
    }
}