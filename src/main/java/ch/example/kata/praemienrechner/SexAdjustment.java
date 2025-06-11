package ch.example.kata.praemienrechner;

public class SexAdjustment implements AdjustmentI<Sex> {

    private static final double FEMALE_DISCOUNT = 0.05;

    @Override
    public Adjustment apply(Premium premium, Sex sex) {
        if (sex.equals(Sex.FEMALE)) {
            return new Adjustment(-premium.personPremium() * FEMALE_DISCOUNT);
        }
        return new Adjustment(0.0);
    }
}
