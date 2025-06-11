package ch.example.kata.praemienrechner;

import java.util.Arrays;
import java.util.List;

public class Person {
    private final int age;
    private final Gender gender;
    private final int einkommen;
    private final Kanton kanton;
    private final RisikoKategorie risikoKategorie;
    private final List<Zusatzattribut> zusatzAttribute;



    public Person(int age, Gender gender, int einkommen, Kanton kanton, RisikoKategorie risikoKategorie, Zusatzattribut... zusatzattribute) {
        if (age < 0) {
            throw new IllegalArgumentException("Alter muss mindestens 0 sein");
        }
        this.age = age;
        this.gender = gender;
        this.einkommen = einkommen;
        this.kanton = kanton;
        this.risikoKategorie = risikoKategorie;
        this.zusatzAttribute = Arrays.asList(zusatzattribute);
    }


    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public int getEinkommen() {
        return einkommen;
    }

    public Kanton getKanton() {
        return kanton;
    }

    public RisikoKategorie getRisikoKategorie() {
        return risikoKategorie;
    }

    public boolean hasZusatzattribute(Zusatzattribut zusatzattribut) {
        return this.zusatzAttribute.contains(zusatzattribut);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", gender=" + gender +
                ", einkommen=" + einkommen +
                ", kanton=" + kanton +
                ", risikoKategorie=" + risikoKategorie +
                ", zusatzAttribute=" + zusatzAttribute +
                '}';
    }
}

