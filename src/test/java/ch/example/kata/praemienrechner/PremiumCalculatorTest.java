package ch.example.kata.praemienrechner;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = new PremiumCalculator();

    @DisplayName("GIVEN female of age 18 WHEN calculate premium THEN get premium of 147.5")
    @Test
    void test1() {
        Person person = createPerson(18, Sex.FEMALE, Canton.AG);
        Premium expectedPremium = new Premium(147.5);

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 18 WHEN calculate premium THEN get premium of 155.0")
    @Test
    void test2() {
        Person person = createPerson(18, Sex.MALE, Canton.AG);
        Premium expectedPremium = new Premium(155.0);

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium).isEqualTo(expectedPremium);
    }

    @DisplayName("GIVEN male of age 18 living in ZH WHEN calculate premium THEN get premium of 170.0")
    @Test
    void test3() {
        Person person = createPerson(18, Sex.MALE, Canton.ZH);
        Premium expectedPremium = new Premium(170.0);

        Premium resultPremium = premiumCalculator.calculate(person);

        assertThat(resultPremium).isEqualTo(expectedPremium);
    }

    @NotNull
    private static Person createPerson(int age, Sex sex, Canton canton) {
        return new Person(age, sex, canton);
    }
}