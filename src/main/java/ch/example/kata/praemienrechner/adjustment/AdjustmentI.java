package ch.example.kata.praemienrechner.adjustment;

import ch.example.kata.praemienrechner.model.Adjustment;
import ch.example.kata.praemienrechner.model.GrossPremium;

public interface AdjustmentI<T> {

    Adjustment apply(GrossPremium premium, T criteria);
}
