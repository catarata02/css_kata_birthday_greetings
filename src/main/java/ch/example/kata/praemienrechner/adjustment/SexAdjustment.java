package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;
import ch.example.kata.praemienrechner.model.Sex;

public class SexAdjustment implements AdjustmentI<Sex> {

    private static final double FEMALE_DISCOUNT = 0.05;

    @Override
    public Adjustment apply(GrossPremium premium, Sex sex) {
        if (sex.equals(Sex.FEMALE)) {
            return new Adjustment(-premium.value() * FEMALE_DISCOUNT, getType(sex));
        }
        return new Adjustment(0.0, getType(sex));
    }

    @Override
    public String getType(Sex criteria) {
        return criteria.name();
    }
}
