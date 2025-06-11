package ch.example.kata.praemienrechner;

import java.util.List;

public class PremiumCalculator {

   GrossPremiumCalculator grossPremiumCalculator  = new GrossPremiumCalculator();
   AdjustmentCalculator adjustmentCalculator = new AdjustmentCalculator();
   
   public Premium calculate(Person person) {
       Premium grossPremium = grossPremiumCalculator.calculate(person);
       List<Adjustment> adjustments = adjustmentCalculator.calculateDiscounts(person, grossPremium);
       double totalDiscount = adjustments.stream().mapToDouble(Adjustment::amount).sum();
       return new Premium(grossPremium.personPremium() + totalDiscount);
   }

}
