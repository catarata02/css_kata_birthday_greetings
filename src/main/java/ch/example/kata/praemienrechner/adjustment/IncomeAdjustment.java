package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;

import java.util.Arrays;

public class IncomeAdjustment implements AdjustmentI<Double> {

    enum IncomeCategory {
        LOW(30000.0, 0.15), MEDIUM(50000.0, 0.05), HIGH(Double.MAX_VALUE, 0.0);

        private final double incomeBorder;
        private final double discount;

        IncomeCategory(double incomeBorder, double discount) {
            this.incomeBorder = incomeBorder;
            this.discount = discount;
        }

        static IncomeCategory fromIncome(double income) {
            return Arrays.stream(IncomeCategory.values())
                    .filter(incomeCategory -> income < incomeCategory.incomeBorder)
                    .findFirst()
                    .orElseThrow();
        }
    }

    @Override
    public Adjustment apply(GrossPremium premium, Double criteria) {
        IncomeCategory incomeCategory = IncomeCategory.fromIncome(criteria);
        return new Adjustment(-incomeCategory.discount * premium.value(), getType(criteria));
    }

    @Override
    public String getType(Double criteria) {
        return "IncomeCategory " + IncomeCategory.fromIncome(criteria).name();
    }
}
