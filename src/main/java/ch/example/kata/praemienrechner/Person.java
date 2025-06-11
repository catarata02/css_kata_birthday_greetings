package ch.example.kata.praemienrechner;

public record Person(int age) {
    public PremiumAge getPremiumAge() {
        return PremiumAge.getPremiumAgeForAge(age);
    }
}
