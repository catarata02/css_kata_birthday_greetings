package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static ch.example.kata.praemienrechner.Zusatzattribut.UNFALLVERSICHERUNG_AUSSCHLUSS;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PremiumCalculatorTest {
    PremiumCalculator testee = new PremiumCalculator();

    Map<Person, Double> testMap = new HashMap<>() {{
        put(new Person(17, Gender.MANN, Kanton.ZH, UNFALLVERSICHERUNG_AUSSCHLUSS), 126.0);
        put(new Person(19, Gender.MANN, Kanton.GE), 175.0);
        put(new Person(26, Gender.MANN, Kanton.AI), 190.0);
        put(new Person(65, Gender.MANN, Kanton.SONSTIGE), 255.0);
        put(new Person(80, Gender.MANN, Kanton.SONSTIGE), 305.0);
        put(new Person(26, Gender.FRAU, Kanton.SONSTIGE), 195.0);
        put(new Person(80, Gender.FRAU, Kanton.SONSTIGE, UNFALLVERSICHERUNG_AUSSCHLUSS), 261.0);
    }};

    @Test
    void calculate_personMitAlter_then_praemie() {
        testMap.forEach((person, praemie) -> {
            assertEquals(praemie, testee.calculate(person), "Praemie calculation failed for " + person.getAge() + " " +  person.getGender());
        });
    }
}