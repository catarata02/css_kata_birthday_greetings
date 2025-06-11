package ch.example.kata.praemienrechner;

public class PremiumCalculator {

   GrossPremiumCalculator grossPremiumCalculator  = new GrossPremiumCalculator();
   DiscountCalculator<Sex> discountCalculator = new SexDiscounter();

   public Premium calculate(Person person) {
       Premium grossPremium = grossPremiumCalculator.calculate(person);
       Discount discount = discountCalculator.apply(grossPremium, person.sex());
       return new Premium(grossPremium.personPremium() - discount.amount());
   }
}
