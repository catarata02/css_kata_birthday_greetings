package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.Canton;
import ch.example.kata.praemienrechner.model.GrossPremium;

import java.util.Map;

public class CantonAdjustment implements AdjustmentI<Canton> {

    Map<Canton, Double> adjustmentMap = Map.of(
            Canton.ZH, 20.0,
            Canton.GE, 25.0,
            Canton.AI, -10.0
    );

    private static final Adjustment DEFAULT_CANTON_ADJUSTMENT = new Adjustment(5.0);

    @Override
    public Adjustment apply(GrossPremium premium, Canton criteria) {
        Double foundValue = adjustmentMap.get(criteria);
        if (foundValue != null) {
            return new Adjustment(foundValue);
        }
        return DEFAULT_CANTON_ADJUSTMENT;
    }
}
