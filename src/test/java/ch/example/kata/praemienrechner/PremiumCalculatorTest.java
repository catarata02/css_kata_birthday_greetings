package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = new PremiumCalculator();

    @Test
    @DisplayName("GIVEN age WHEN calculatePremium THEN expected premium is calculated")
    void test1() {
        Person person = new Person(1);

        Premium premium = premiumCalculator.calculate(person);
        
        assertThat(premium.personPremium()).isEqualTo(Double.valueOf(120));
    }
}