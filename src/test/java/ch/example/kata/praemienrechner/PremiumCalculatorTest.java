package ch.example.kata.praemienrechner;

import ch.example.kata.praemienrechner.model.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = new PremiumCalculator();

    @DisplayName("GIVEN female of age 18 WHEN calculate premium THEN get premium of 147.5")
    @Test
    void test1() {
        Person person = createPerson(18, Sex.FEMALE, Canton.AG, true, Collections.emptyList(), 55000.0);
        double expectedPremium = 147.5;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 18 WHEN calculate premium THEN get premium of 155.0")
    @Test
    void test2() {
        Person person = createPerson(18, Sex.MALE, Canton.AG, true, Collections.emptyList(), 55000.0);
        double expectedPremium = 155.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 18 living in ZH WHEN calculate premium THEN get premium of 170.0")
    @Test
    void test3() {
        Person person = createPerson(18, Sex.MALE, Canton.ZH, true, Collections.emptyList(), 55000.0);
        double expectedPremium = 170.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 45 living in LU with accident insurance WHEN calculate premium THEN get premium of 205.0")
    @Test
    void test4() {
        Person person = createPerson(45, Sex.MALE, Canton.LU, true, Collections.emptyList(), 55000.0);
        double expectedPremium = 205.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 45 living in LU without accident insurance WHEN calculate premium THEN get premium of 185.0")
    @Test
    void test5() {
        Person person = createPerson(45, Sex.MALE, Canton.LU, false, Collections.emptyList(), 55000.0);
        double expectedPremium = 185.0;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName(
            "GIVEN male of age 45 living in LU with accident insurance and all additional insurance " +
                    "WHEN calculate premium " +
                    "THEN get premium of 290.0")
    @Test
    void test6() {
        Person person = createPerson(
                45,
                Sex.MALE,
                Canton.LU,
                true,
                Arrays.asList(AdditionalInsurance.KOMPLEMENTAER_MEDIZIN, AdditionalInsurance.SEH_HILFE, AdditionalInsurance.ZAHN_MEDIZIN), 55000.0
        );
        double expectedPremium = 290;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @DisplayName(
            "GIVEN male of age 45 living in LU with accident insurance and all additional insurance and LOW income " +
                    "WHEN calculate premium " +
                    "THEN get premium of 290.0")
    @Test
    void test7() {
        Person person = createPerson(
                45,
                Sex.MALE,
                Canton.LU,
                true,
                Arrays.asList(AdditionalInsurance.KOMPLEMENTAER_MEDIZIN, AdditionalInsurance.SEH_HILFE, AdditionalInsurance.ZAHN_MEDIZIN), 
                15000.0
        );
        double expectedPremium = 260;

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium.getNet()).isEqualTo(expectedPremium);
    }

    @NotNull
    private static Person createPerson(int age, Sex sex, Canton canton, boolean accidentInsured, List<AdditionalInsurance> additionalInsuranceList, double income) {
        return new Person(age, sex, canton, income, accidentInsured, additionalInsuranceList);
    }
}