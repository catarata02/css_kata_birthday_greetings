package ch.example.kata.praemienrechner;

import ch.example.kata.praemienrechner.model.GrossPremium;
import ch.example.kata.praemienrechner.model.Person;
import ch.example.kata.praemienrechner.model.PremiumAge;

public class GrossPremiumCalculator {
    public GrossPremium calculate(Person person) {
        PremiumAge premiumAge = person.getPremiumAge();
        return switch (premiumAge) {
            case UNTER_18 -> new GrossPremium(120.0);
            case UNTER_26 -> new GrossPremium(150.0);
            case UNTER_46 -> new GrossPremium(200.0);
            case UNTER_66 -> new GrossPremium(250.0);
            case UNTER_200 -> new GrossPremium(300.0);
        };
    }
}
