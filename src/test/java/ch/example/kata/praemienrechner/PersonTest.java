package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void whenAgeInvalid_then_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person testee = new Person(-12, Gender.MANN, 30_000, Kanton.ZH, RisikoKategorie.GERINGES_RISIKO);
        });
    }

}