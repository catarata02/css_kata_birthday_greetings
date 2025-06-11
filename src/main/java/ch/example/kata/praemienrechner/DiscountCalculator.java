package ch.example.kata.praemienrechner;

public interface DiscountCalculator <T> {

    Discount apply(Premium premium, T criteria);
}
