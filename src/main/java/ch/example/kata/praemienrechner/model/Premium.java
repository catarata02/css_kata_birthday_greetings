package ch.example.kata.praemienrechner.model;

import java.util.List;

public record Premium(GrossPremium grossPremium, List<Adjustment> adjustments) {
    public double getNet() {
        return grossPremium.value() + totalDiscount();
    }

    private double totalDiscount() {
        return adjustments.stream().mapToDouble(Adjustment::amount).sum();
    }
}
