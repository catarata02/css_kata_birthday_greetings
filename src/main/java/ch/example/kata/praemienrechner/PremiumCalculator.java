package ch.example.kata.praemienrechner;

import ch.example.kata.praemienrechner.adjustment.AdjustmentCalculator;
import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;
import ch.example.kata.praemienrechner.model.Person;
import ch.example.kata.praemienrechner.model.Premium;

import java.util.List;

public class PremiumCalculator {

    GrossPremiumCalculator grossPremiumCalculator = new GrossPremiumCalculator();
    AdjustmentCalculator adjustmentCalculator = new AdjustmentCalculator();

    public Premium calculate(Person person) {
        GrossPremium grossPremium = grossPremiumCalculator.calculate(person);
        List<Adjustment> adjustments = adjustmentCalculator.calculateDiscounts(person, grossPremium);
        return new Premium(grossPremium, adjustments);
    }

}
