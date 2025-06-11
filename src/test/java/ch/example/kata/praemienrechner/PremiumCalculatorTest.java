package ch.example.kata.praemienrechner;

import ch.example.kata.praemienrechner.model.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = new PremiumCalculator();

    @DisplayName("GIVEN female of age 18 WHEN calculate premium THEN get premium of 147.5")
    @Test
    void test1() {
        Person person = createPerson(18, Sex.FEMALE, Canton.AG, true);
        double expectedPremium = 147.5;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 18 WHEN calculate premium THEN get premium of 155.0")
    @Test
    void test2() {
        Person person = createPerson(18, Sex.MALE, Canton.AG, true);
        double expectedPremium = 155.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 18 living in ZH WHEN calculate premium THEN get premium of 170.0")
    @Test
    void test3() {
        Person person = createPerson(18, Sex.MALE, Canton.ZH, true);
        double expectedPremium = 170.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 45 living in LU with accident insurance WHEN calculate premium THEN get premium of 170.0")
    @Test
    void test4() {
        Person person = createPerson(45, Sex.MALE, Canton.LU, true);
        double expectedPremium = 205.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 45 living in LU without accident insurance WHEN calculate premium THEN get premium of 170.0")
    @Test
    void test5() {
        Person person = createPerson(45, Sex.MALE, Canton.LU, false);
        double expectedPremium = 185.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @NotNull
    private static Person createPerson(int age, Sex sex, Canton canton, boolean accidentInsured) {
        return new Person(age, sex, canton, accidentInsured);
    }
}