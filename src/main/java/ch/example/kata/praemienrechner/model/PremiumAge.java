package ch.example.kata.praemienrechner.model;

import java.util.Arrays;

public enum PremiumAge {
    UNTER_18(18), UNTER_26(26), UNTER_46(46), UNTER_66(66), UNTER_200(200);

    private final int age;

    PremiumAge(int age) {
        this.age = age;
    }

    public static PremiumAge getPremiumAgeForAge(int queryAge) {
        return Arrays.stream(PremiumAge.values())
                .filter(premiumAge -> queryAge < premiumAge.age)
                .findFirst()
                .orElseThrow();
    }

}
