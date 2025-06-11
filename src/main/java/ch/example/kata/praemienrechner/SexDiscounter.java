package ch.example.kata.praemienrechner;

public class SexDiscounter implements DiscountCalculator<Sex> {

    private static final double FEMALE_DISCOUNT = 0.05;

    @Override
    public Discount apply(Premium premium, Sex sex) {
        if (sex.equals(Sex.FEMALE)) {
            return new Discount(-premium.personPremium() * FEMALE_DISCOUNT);
        }
        return new Discount(0.0);
    }
}
