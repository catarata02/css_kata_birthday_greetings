package ch.example.kata.praemienrechner.model;

import java.util.List;

public record Person(
        int age, 
        Sex sex, 
        Canton canton, 
        double income,
        boolean accidentInsured, 
        List<AdditionalInsurance> additionalInsuranceList
) {
    public PremiumAge getPremiumAge() {
        return PremiumAge.getPremiumAgeForAge(age);
    }
}
