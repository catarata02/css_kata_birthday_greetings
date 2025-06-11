package ch.example.kata.praemienrechner;

public class PremiumCalculator {
    public double calculate(Person person) {
        if (person.getAge() < 18) {
            return 120.0;
        }
        if (person.getAge() <= 25) {
            return 150.0;
        }
        if (person.getAge() <= 45) {
            return 200.0;
        }
        if (person.getAge() <= 65) {
            return 250.0;
        }
        return 300.0;
    };
}
