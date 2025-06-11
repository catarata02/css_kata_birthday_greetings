package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PremiumAgeTest {

    @ParameterizedTest(name = "GIVEN age {0} WHEN getPremiumAgeForAge THEN return {1}")
    @CsvSource({
            "1, UNTER_18",
            "17, UNTER_18",
            "18, UNTER_26",
            "25, UNTER_26",
            "26, UNTER_46",
            "45, UNTER_46",
            "46, UNTER_66",
            "65, UNTER_66",
            "66, UNTER_200",
            "100, UNTER_200"
    })
    @DisplayName("Should return correct PremiumAge enum for given age")
    void getPremiumAgeForAgeParameterized(int age, PremiumAge expected) {
        PremiumAge result = PremiumAge.getPremiumAgeForAge(age);
        assertThat(result).isEqualTo(expected);
    }
}