package ch.example.kata.praemienrechner;

public class PremiumCalculator {
    public double calculate(Person person) {
        return switch (person.getAlterGruppe()) {
            case AlterGruppe.JUNGE -> 120.0;
            case AlterGruppe.ERWACHSENE_BIS_25 -> 150.0;
            case AlterGruppe.ERWACHSENE_BIS_45 -> 200.0;
            case AlterGruppe.ERWACHSENE_BIS_65 -> 250.0;
            case AlterGruppe.RENTNER -> 300.0;
        } * (person.getGender() == Gender.FRAU ? .95 : 1.0);
    }
}
