package ch.example.kata.praemienrechner;

public class Person {
    private final Gender gender;
    private final int age;


    public Person(int age, Gender gender) {
        if (age < 0) {
            throw new IllegalArgumentException("Alter muss mindestens 0 sein");
        }
        this.age = age;
        this.gender = gender;
    }


    public int getAge() {
        return age;
    }


    public Gender getGender() {
        return gender;
    }
}

enum Gender {
    MANN, FRAU
}