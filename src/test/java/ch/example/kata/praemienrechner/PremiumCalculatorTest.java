package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static ch.example.kata.praemienrechner.Zusatzattribut.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PremiumCalculatorTest {
    static final int EINKOMMEN_NIEDRIG = 20_000;
    static final int EINKOMMEN_MITTEL = 40_000;
    static final int EINKOMMEN_HOCH = 120_000;

    PremiumCalculator testee = new PremiumCalculator();

    Map<Person, Double> testMap = new HashMap<>() {{
        put(new Person(17, Gender.MANN, EINKOMMEN_NIEDRIG, Kanton.ZH, UNFALLVERSICHERUNG_AUSSCHLUSS), 107.1);
        put(new Person(19, Gender.MANN, EINKOMMEN_HOCH, Kanton.GE), 175.0);
        put(new Person(26, Gender.MANN, EINKOMMEN_MITTEL, Kanton.AI), 180.5);
        put(new Person(65, Gender.MANN, EINKOMMEN_HOCH, Kanton.SONSTIGE), 255.0);
        put(new Person(80, Gender.MANN, EINKOMMEN_HOCH, Kanton.SONSTIGE), 305.0);
        put(new Person(26, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE), 195.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, UNFALLVERSICHERUNG_AUSSCHLUSS), 261.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, ZAHNVERSICHERUNG), 320.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, SEHHILFE), 305.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, KOMPLEMENTAERMEDIZIN), 330.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, KOMPLEMENTAERMEDIZIN, ZAHNVERSICHERUNG), 360.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, KOMPLEMENTAERMEDIZIN, ZAHNVERSICHERUNG, SEHHILFE), 375.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, ZAHNVERSICHERUNG, SEHHILFE), 335.0);
        put(new Person(80, Gender.FRAU, EINKOMMEN_HOCH, Kanton.SONSTIGE, HAT_FAMILIE), 270.0);
    }};

    @Test
    void calculate_personMitAlter_then_praemie() {
        testMap.forEach((person, praemie) -> {
            assertEquals(praemie, testee.calculate(person), "Praemie calculation failed for " + person);
        });
    }
}