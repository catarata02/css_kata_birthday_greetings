package ch.example.kata.praemienrechner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SexAdjustmentTest {

    private final SexAdjustment sexAdjustment = new SexAdjustment();

    @DisplayName("GIVEN female and premium 100 WHEN apply discount THEN discount is 5")
    @Test
    void test1() {
        Premium premium = new Premium(100.00);
        Adjustment expectedAdjustment = new Adjustment(-5.00);

        Adjustment resultAdjustment = sexAdjustment.apply(premium, Sex.FEMALE);

        assertThat(resultAdjustment).isEqualTo(expectedAdjustment);
    }

    @DisplayName("GIVEN male and premium 100 WHEN apply discount THEN discount is 0")
    @Test
    void test2() {
        Premium premium = new Premium(100.00);
        Adjustment expectedAdjustment = new Adjustment(0.00);

        Adjustment resultAdjustment = sexAdjustment.apply(premium, Sex.MALE);

        assertThat(resultAdjustment).isEqualTo(expectedAdjustment);
    }
}