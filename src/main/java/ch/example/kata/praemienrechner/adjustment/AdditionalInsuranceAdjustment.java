package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.AdditionalInsurance;
import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;

public class AdditionalInsuranceAdjustment implements AdjustmentI<AdditionalInsurance> {
    @Override
    public Adjustment apply(GrossPremium premium, AdditionalInsurance criteria) {
        return new Adjustment(criteria.getAdjustment(), getType(criteria));
    }

    @Override
    public String getType(AdditionalInsurance criteria) {
        return criteria.name();
    }
}
