package ch.example.kata.praemienrechner;

public interface AdjustmentI<T> {

    Adjustment apply(Premium premium, T criteria);
}
