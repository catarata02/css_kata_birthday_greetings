package ch.example.kata.praemienrechner;

public class Person {
    private int age;


    public Person(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Alter muss mindestens 0 sein");
        }
        this.age = age;
    }


    public int getAge() {
        return age;

    }
}
