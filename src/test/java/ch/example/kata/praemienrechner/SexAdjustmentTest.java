package ch.example.kata.praemienrechner;

import ch.example.kata.praemienrechner.adjustment.SexAdjustment;
import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;
import ch.example.kata.praemienrechner.model.Sex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SexAdjustmentTest {

    private final SexAdjustment sexAdjustment = new SexAdjustment();

    @DisplayName("GIVEN female and premium 100 WHEN apply discount THEN discount is 5")
    @Test
    void test1() {
        GrossPremium premium = new GrossPremium(100.00);
        Adjustment expectedAdjustment = new Adjustment(-5.00, Sex.FEMALE.name());

        Adjustment resultAdjustment = sexAdjustment.apply(premium, Sex.FEMALE);

        assertThat(resultAdjustment.amount()).isEqualTo(expectedAdjustment);
    }

    @DisplayName("GIVEN male and premium 100 WHEN apply discount THEN discount is 0")
    @Test
    void test2() {
        GrossPremium premium = new GrossPremium(100.00);
        Adjustment expectedAdjustment = new Adjustment(0.00, Sex.MALE.name());

        Adjustment resultAdjustment = sexAdjustment.apply(premium, Sex.MALE);

        assertThat(resultAdjustment).isEqualTo(expectedAdjustment);
    }
}