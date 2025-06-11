package ch.example.kata.praemienrechner;

public class PremiumCalculator {
    public double calculate(Person person) {
        double grundPraemie = Tarife.from(person).getPraemie();
        return Rabatte.applyRabatte(person, grundPraemie);
    }
}