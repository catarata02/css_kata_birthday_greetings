package ch.example.kata.praemienrechner;

public class PremiumCalculator {
    public Premium calculate(Person person) {
        if (person.age() < 18) {
            return new Premium(120.0);
        }
        return null;
    }
}
