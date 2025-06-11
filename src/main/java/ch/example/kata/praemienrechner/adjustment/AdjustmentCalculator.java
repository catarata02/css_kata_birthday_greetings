package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;
import ch.example.kata.praemienrechner.model.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdjustmentCalculator {
    public List<Adjustment> calculateDiscounts(Person person, GrossPremium grossPremium) {
        Adjustment sexAdjustment = calculateSexDiscount(person, grossPremium);
        Adjustment cantonAdjustment = calculateCantonDiscount(person, grossPremium);
        Adjustment accidentExclusionAdjustment = calculateAccidentExclusionDiscount(person, grossPremium);
        List<Adjustment> additionalInsurancesAdjustments = calculateAdditionalInsurances(person, grossPremium);

        return Stream.concat(
                Stream.of(sexAdjustment, cantonAdjustment, accidentExclusionAdjustment),
                additionalInsurancesAdjustments.stream()
        ).toList();
    }

    private List<Adjustment> calculateAdditionalInsurances(Person person, GrossPremium grossPremium) {
        AdditionalInsuranceAdjustment additionalInsuranceAdjustment = new AdditionalInsuranceAdjustment();
        return person.additionalInsuranceList().stream()
                .map(it -> additionalInsuranceAdjustment.apply(grossPremium, it))
                .collect(Collectors.toList());
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
