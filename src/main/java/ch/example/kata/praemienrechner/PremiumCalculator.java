package ch.example.kata.praemienrechner;

import java.util.Arrays;
import java.util.List;

public class PremiumCalculator {

   GrossPremiumCalculator grossPremiumCalculator  = new GrossPremiumCalculator();
   
   public Premium calculate(Person person) {
       Premium grossPremium = grossPremiumCalculator.calculate(person);
       List<Discount> discounts = calculateDiscounts(person, grossPremium);
       double totalDiscount = discounts.stream().mapToDouble(Discount::amount).sum();
       return new Premium(grossPremium.personPremium() + totalDiscount);
   }

    private List<Discount> calculateDiscounts(Person person, Premium grossPremium) {
        SexDiscounter sexDiscounter = new SexDiscounter();
        Discount sexDiscount = sexDiscounter.apply(grossPremium, person.sex());
        
        CantonDiscounter cantonDiscounter = new CantonDiscounter();
        Discount cantonDiscount = cantonDiscounter.apply(grossPremium, person.canton());
        
        return Arrays.asList(sexDiscount, cantonDiscount);
    }
}
