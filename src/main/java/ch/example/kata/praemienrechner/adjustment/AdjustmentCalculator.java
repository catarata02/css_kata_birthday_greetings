package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;
import ch.example.kata.praemienrechner.model.Person;

import java.util.Arrays;
import java.util.List;

public class AdjustmentCalculator {
    public List<Adjustment> calculateDiscounts(Person person, GrossPremium grossPremium) {
        Adjustment sexAdjustment = calculateSexDiscount(person, grossPremium);
        Adjustment cantonAdjustment = calculateCantonDiscount(person, grossPremium);
        Adjustment accidentExclusionAdjustment = calculateAccidentExclusionDiscount(person, grossPremium);

        return Arrays.asList(sexAdjustment, cantonAdjustment, accidentExclusionAdjustment);
    }

    private Adjustment calculateAccidentExclusionDiscount(Person person, GrossPremium grossPremium) {
        AccidentInsuranceAdjustment accidentInsuranceAdjustment = new AccidentInsuranceAdjustment();
        return accidentInsuranceAdjustment.apply(grossPremium, person.accidentInsured());
    }

    private static Adjustment calculateCantonDiscount(Person person, GrossPremium grossPremium) {
        CantonAdjustment cantonDiscounter = new CantonAdjustment();
        return cantonDiscounter.apply(grossPremium, person.canton());
    }

    private static Adjustment calculateSexDiscount(Person person, GrossPremium grossPremium) {
        SexAdjustment sexDiscounter = new SexAdjustment();
        return sexDiscounter.apply(grossPremium, person.sex());
    }
}
