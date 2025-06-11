package ch.example.kata.praemienrechner;

import java.util.function.Function;

enum Rabatte {
    FRAUENRABATT((Person person) -> person.getGender().equals(Gender.FRAU), (Double praemie) -> praemie * .95);
    final Function<Person, Boolean> predicate;
    final Function<Double, Double> modifier;

    Rabatte(Function<Person, Boolean> predicate, Function<Double, Double> modifier) {
        this.predicate = predicate;
        this.modifier = modifier;
    }

    public static double applyRabatte(Person person, double grundPraemie) {
        double praemie = grundPraemie;
        for (Rabatte rabatte : Rabatte.values()) {
            if (rabatte.predicate.apply(person)) {
                praemie = rabatte.modifier.apply(praemie);
            }
        }
        return praemie;
    }
}
