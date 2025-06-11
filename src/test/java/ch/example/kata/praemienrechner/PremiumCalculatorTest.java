package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = new PremiumCalculator();

    static Stream<org.junit.jupiter.params.provider.Arguments> providePersonsAndExpectedPremiums() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new Person(1), new Premium(120.0)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(18), new Premium(150)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(26), new Premium(200.0)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(46), new Premium(250.0)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(66), new Premium(300.0))
        );
    }

    @ParameterizedTest(name = "GIVEN person age {0} WHEN calculate THEN premium should be {1}")
    @MethodSource("providePersonsAndExpectedPremiums")
    @DisplayName("GIVEN person WHEN calculatePremium THEN expected premium is returned")
    void calculatePremiumParameterized(Person person, Premium expectedPremium) {
        Premium actualPremium = premiumCalculator.calculate(person);
        assertThat(actualPremium.personPremium()).isEqualTo(expectedPremium.personPremium());
    }
}