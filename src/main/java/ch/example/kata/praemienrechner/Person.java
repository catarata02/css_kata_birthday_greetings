package ch.example.kata.praemienrechner;

import java.util.Arrays;
import java.util.List;

public class Person {
    private final Gender gender;
    private final int age;
    private final Kanton kanton;
    private final List<Zusatzattribut> zusatzAttribute;



    public Person(int age, Gender gender, Kanton kanton, Zusatzattribut... zusatzattribute) {
        if (age < 0) {
            throw new IllegalArgumentException("Alter muss mindestens 0 sein");
        }
        this.age = age;
        this.gender = gender;
        this.kanton = kanton;
        this.zusatzAttribute = Arrays.asList(zusatzattribute);
    }


    public int getAge() {
        return age;
    }


    public Gender getGender() {
        return gender;
    }

    public Kanton getKanton() {
        return kanton;
    }

    public boolean hasZusatzattribute(Zusatzattribut zusatzattribut) {
        return this.zusatzAttribute.contains(zusatzattribut);
    }
}

