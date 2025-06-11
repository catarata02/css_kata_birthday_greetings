package ch.example.kata.praemienrechner;

import java.util.Arrays;
import java.util.List;

public class AdjustmentCalculator {
    List<Adjustment> calculateDiscounts(Person person, Premium grossPremium) {
        Adjustment sexAdjustment = calculateSexDiscount(person, grossPremium);
        Adjustment cantonAdjustment = calculateCantonDiscount(person, grossPremium);

        return Arrays.asList(sexAdjustment, cantonAdjustment);
    }

    private static Adjustment calculateCantonDiscount(Person person, Premium grossPremium) {
        CantonAdjustment cantonDiscounter = new CantonAdjustment();
        Adjustment cantonAdjustment = cantonDiscounter.apply(grossPremium, person.canton());
        return cantonAdjustment;
    }

    private static Adjustment calculateSexDiscount(Person person, Premium grossPremium) {
        SexAdjustment sexDiscounter = new SexAdjustment();
        Adjustment sexAdjustment = sexDiscounter.apply(grossPremium, person.sex());
        return sexAdjustment;
    }
}
