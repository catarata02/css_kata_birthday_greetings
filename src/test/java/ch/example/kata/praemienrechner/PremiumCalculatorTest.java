package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = new PremiumCalculator();

    @DisplayName("GIVEN female of age 18 WHEN calculate premium THEN get premium of 142.5")
    @Test
    void test1() {
        Person person = new Person(18, Sex.FEMALE);
        Premium expectedPremium = new Premium(142.5);

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 18 WHEN calculate premium THEN get premium of 150.0")
    @Test
    void test2() {
        Person person = new Person(18, Sex.MALE);
        Premium expectedPremium = new Premium(150.0);

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium).isEqualTo(expectedPremium);
    }
}