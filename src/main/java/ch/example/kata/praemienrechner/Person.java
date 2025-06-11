package ch.example.kata.praemienrechner;

public record Person(int age, Sex sex) {
    public PremiumAge getPremiumAge() {
        return PremiumAge.getPremiumAgeForAge(age);
    }
}
