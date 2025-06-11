package ch.example.kata.praemienrechner;

import java.util.Arrays;

public enum Tarife {
    JUNGE(120) {
        @Override
        public boolean doesMatch(Person person) {
            return person.getAge() < 18;
        }
    },
    ERWACHSENE_BIS_25(150) {
        @Override
        public boolean doesMatch(Person person) {
            return person.getAge() <= 25;
        }
    },
    ERWACHSENE_BIS_45(200) {
        @Override
        public boolean doesMatch(Person person) {
            return person.getAge() <= 45;
        }
    },
    ERWACHSENE_BIS_65(250) {
        @Override
        public boolean doesMatch(Person person) {
            return person.getAge() <= 65;
        }
    },
    RENTNER(300) {
        @Override
        public boolean doesMatch(Person person) {
            return person.getAge() > 65;
        }
    };

    private final double praemie;

    Tarife(double praemie) {
        this.praemie = praemie;
    }

    public double getPraemie() {
        return praemie;
    }

    abstract public boolean doesMatch(Person person);

    public static Tarife from(Person p) {
        return Arrays.stream(values()).filter(it -> it.doesMatch(p)).findFirst().orElseThrow();
    }
}
