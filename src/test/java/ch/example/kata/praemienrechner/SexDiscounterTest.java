package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SexDiscounterTest {

    private final SexDiscounter sexDiscounter = new SexDiscounter();

    @DisplayName("GIVEN female and premium 100 WHEN apply discount THEN discount is 5")
    @Test
    void test1() {
        Premium premium = new Premium(100.00);
        Discount expectedDiscount = new Discount(5.00);

        Discount resultDiscount = sexDiscounter.apply(premium, Sex.FEMALE);

        assertThat(resultDiscount).isEqualTo(expectedDiscount);
    }

    @DisplayName("GIVEN male and premium 100 WHEN apply discount THEN discount is 0")
    @Test
    void test2() {
        Premium premium = new Premium(100.00);
        Discount expectedDiscount = new Discount(0.00);

        Discount resultDiscount = sexDiscounter.apply(premium, Sex.MALE);

        assertThat(resultDiscount).isEqualTo(expectedDiscount);
    }
}