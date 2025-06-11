package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PremiumCalculatorTest {
    PremiumCalculator testee = new PremiumCalculator();

    Map<Person, Double> testMap = new HashMap<>() {{
        put(new Person(17, Gender.MANN), 120.0);
        put(new Person(19, Gender.MANN), 150.0);
        put(new Person(26, Gender.MANN), 200.0);
        put(new Person(65, Gender.MANN), 250.0);
        put(new Person(80, Gender.MANN), 300.0);
        put(new Person(26, Gender.FRAU), 190.0);
        put(new Person(80, Gender.FRAU), 285.0);
    }};

    @Test
    void calculate_personMitAlter_then_praemie() {
        testMap.forEach((person, praemie) -> {
            assertEquals(praemie, testee.calculate(person), "Praemie calculation failed for " + person.getAge() + " " +  person.getGender());
        });
    }
}