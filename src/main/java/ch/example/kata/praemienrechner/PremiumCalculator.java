package ch.example.kata.praemienrechner;

public class PremiumCalculator {
    public Premium calculate(Person person) {
        PremiumAge premiumAge = person.getPremiumAge();
        return switch (premiumAge) {
            case UNTER_18 -> new Premium(120.0);
            case UNTER_26 -> new Premium(150.0);
            case UNTER_46 -> new Premium(200.0);
            case UNTER_66 -> new Premium(250.0);
            case UNTER_200 -> new Premium(300.0);
        };
    }
}
