package ch.example.kata.praemienrechner;

import java.util.Map;

public class CantonDiscounter implements DiscountCalculator<Canton> {

    Map<Canton, Double> adjustmentMap = Map.of(
            Canton.ZH, 20.0, 
            Canton.GE, 25.0,
            Canton.AI, -10.0
    );
    
    private static final Discount DEFAULT_CANTON_DISCOUNT = new Discount(5.0);

    @Override
    public Discount apply(Premium premium, Canton criteria) {
        Double foundValue = adjustmentMap.get(criteria);
        if (foundValue != null) {
            return new Discount(foundValue);
        }
        return DEFAULT_CANTON_DISCOUNT;
    }
}
