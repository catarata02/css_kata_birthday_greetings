package ch.example.kata.praemienrechner;

import ch.example.kata.praemienrechner.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GrossPremiumCalculatorTest {

    private final GrossPremiumCalculator grossPremiumCalculator = new GrossPremiumCalculator();

    static Stream<org.junit.jupiter.params.provider.Arguments> providePersonsAndExpectedPremiums() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new Person(1, Sex.FEMALE, Canton.AG), new GrossPremium(120.0)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(18, Sex.FEMALE, Canton.AG), new GrossPremium(150)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(26, Sex.FEMALE, Canton.AG), new GrossPremium(200.0)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(46, Sex.FEMALE, Canton.AG), new GrossPremium(250.0)),
                org.junit.jupiter.params.provider.Arguments.of(new Person(66, Sex.FEMALE, Canton.AG), new GrossPremium(300.0))
        );
    }

    @ParameterizedTest(name = "GIVEN person age {0} WHEN calculate THEN premium should be {1}")
    @MethodSource("providePersonsAndExpectedPremiums")
    @DisplayName("GIVEN person WHEN calculatePremium THEN expected premium is returned")
    void calculatePremiumParameterized(Person person, GrossPremium expectedPremium) {
        GrossPremium actualPremium = grossPremiumCalculator.calculate(person);
        assertThat(actualPremium.value()).isEqualTo(expectedPremium.value());
    }
}