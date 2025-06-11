package ch.example.kata.praemienrechner;

import java.util.function.Function;

enum Tarife {
    GRUNDTARIF_JUNGE(p->p.getAge() < 18, x->120.0) ,
    GRUNDTARIF_ERWACHSENE_BIS_25(p->p.getAge() >= 18 && p.getAge() <= 25, x->150.0) ,
    GRUNDTARIF_ERWACHSENE_BIS_45(p->p.getAge() > 25 && p.getAge() <= 45, x->200.0) ,
    GRUNDTARIF_ERWACHSENE_BIS_65(p->p.getAge() > 45 && p.getAge() <= 65, x->250.0) ,
    GRUNDTARIF_RENTNER(p->p.getAge() > 65 , x->300.0) ,

    FRAUENRABATT((Person person) -> person.getGender().equals(Gender.FRAU), (Double praemie) -> praemie * .95);
    final Function<Person, Boolean> predicate;
    final Function<Double, Double> modifier;

    Tarife(Function<Person, Boolean> predicate, Function<Double, Double> modifier) {
        this.predicate = predicate;
        this.modifier = modifier;
    }

    public static double applyTarife(Person person) {
        double praemie = 0;
        for (Tarife tarife : Tarife.values()) {
            if (tarife.predicate.apply(person)) {
                praemie = tarife.modifier.apply(praemie);
            }
        }
        return praemie;
    }
}
