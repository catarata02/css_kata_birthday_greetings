package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;

public class AccidentInsuranceAdjustment implements AdjustmentI<Boolean>{

    private static final double ACCIDENT_EXCLUDED_DISCOUNT = 0.10;
    @Override
    public Adjustment apply(GrossPremium premium, Boolean criteria) {
        if (Boolean.FALSE.equals(criteria)) {
            // accident not insured, gets discount
            return new Adjustment(-premium.value() * ACCIDENT_EXCLUDED_DISCOUNT, getType(criteria));
        }
        return new Adjustment(0.0, getType(criteria));
    }

    @Override
    public String getType(Boolean criteria) {
        return "Accident " + (criteria ? "included" : "excluded");
    }
}
