package ch.example.kata.praemienrechner;

import java.util.function.Function;

enum Tarif {
    GRUNDTARIF_JUNGE(p -> p.getAge() < 18, x -> 120.0),
    GRUNDTARIF_ERWACHSENE_BIS_25(p -> p.getAge() >= 18 && p.getAge() <= 25, x -> 150.0),
    GRUNDTARIF_ERWACHSENE_BIS_45(p -> p.getAge() > 25 && p.getAge() <= 45, x -> 200.0),
    GRUNDTARIF_ERWACHSENE_BIS_65(p -> p.getAge() > 45 && p.getAge() <= 65, x -> 250.0),
    GRUNDTARIF_RENTNER(p -> p.getAge() > 65, x -> 300.0),

    FRAUENRABATT((Person person) -> person.getGender().equals(Gender.FRAU), (Double praemie) -> praemie * 0.95),

    KANTONALER_ZUSCHLAG_ZH(p -> p.getKanton().equals(Kanton.ZH), pramie -> pramie + 20),
    KANTONALER_ZUSCHLAG_GE(p -> p.getKanton().equals(Kanton.GE), pramie -> pramie + 25),
    KANTONALER_ZUSCHLAG_AI(p -> p.getKanton().equals(Kanton.AI), pramie -> pramie - 10),
    KANTONALER_ZUSCHLAG_SONSTIGE(p -> p.getKanton().equals(Kanton.SONSTIGE), pramie -> pramie + 5),

    RABATT_UNFALLVERSICHERUNG_AUSSCHLUSS(p -> p.hasZusatzattribute(Zusatzattribut.UNFALLVERSICHERUNG_AUSSCHLUSS), praemie -> praemie * 0.90),
    ZUSCHLAG_ZAHNVERSICHERUNG(p -> p.hasZusatzattribute(Zusatzattribut.ZAHNVERSICHERUNG), praemie -> praemie + 30),
    ZUSCHLAG_SEHHILFE(p -> p.hasZusatzattribute(Zusatzattribut.SEHHILFE), praemie -> praemie + 15),
    ZUSCHLAG_KOMPLEMENTAERMEDIZIN(p -> p.hasZusatzattribute(Zusatzattribut.KOMPLEMENTAERMEDIZIN), praemie -> praemie + 40),

    RABATT_NIEDRIGES_EINKOMMEN(p -> p.getEinkommen() < 30_000, praemie -> praemie * 0.85),
    RABATT_MITTLERES_EINKOMMEN(p -> p.getEinkommen() >= 30_000 && p.getEinkommen() <= 50_000, praemie -> praemie * 0.95),
    RABATT_FAMILIE(p -> p.hasZusatzattribute(Zusatzattribut.HAT_FAMILIE), praemie -> praemie - 20),
    RABATT_TREUEBONUS(p -> p.hasZusatzattribute(Zusatzattribut.IST_ZUVERLAESSIG), praemie -> praemie - 10),
    ;
    final Function<Person, Boolean> predicate;
    final Function<Double, Double> modifier;

    Tarif(Function<Person, Boolean> predicate, Function<Double, Double> modifier) {
        this.predicate = predicate;
        this.modifier = modifier;
    }

    public static double applyTarife(Person person) {
        System.out.println("Applying Tarif for person: " + person);
        double praemie = 0;
        for (Tarif tarif : Tarif.values()) {
            if (tarif.predicate.apply(person)) {
                praemie = tarif.modifier.apply(praemie);
                System.out.println(praemie + " CHF " + tarif);
            }
        }
        return praemie;
    }
}
