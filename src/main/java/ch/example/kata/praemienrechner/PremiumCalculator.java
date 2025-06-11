package ch.example.kata.praemienrechner;

public class PremiumCalculator {
    public double calculate(Person person) {
        return Tarife.applyTarife(person);
    }
}