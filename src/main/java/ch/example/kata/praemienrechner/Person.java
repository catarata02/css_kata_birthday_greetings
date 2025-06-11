package ch.example.kata.praemienrechner;

public class Person {
    private final AlterGruppe alterGruppe;
    private final Gender gender;


    public Person(int age, Gender gender) {
        if (age < 0) {
            throw new IllegalArgumentException("Alter muss mindestens 0 sein");
        }
        this.alterGruppe = berechneAlterGruppe(age);
        this.gender = gender;
    }

    private AlterGruppe berechneAlterGruppe(int age) {
        if (age < 18) {
            return AlterGruppe.JUNGE;
        }
        if (age <= 25) {
            return AlterGruppe.ERWACHSENE_BIS_25;
        }
        if (age <= 45) {
            return AlterGruppe.ERWACHSENE_BIS_45;
        }
        if (age <= 65) {
            return AlterGruppe.ERWACHSENE_BIS_65;
        }
        return AlterGruppe.RENTNER;
    }

    public AlterGruppe getAlterGruppe() {
        return alterGruppe;
    }

    public Gender getGender() {
        return gender;
    }
}

enum AlterGruppe {
    JUNGE, ERWACHSENE_BIS_25, ERWACHSENE_BIS_45, ERWACHSENE_BIS_65, RENTNER
}
enum Gender {
    MANN, FRAU
}