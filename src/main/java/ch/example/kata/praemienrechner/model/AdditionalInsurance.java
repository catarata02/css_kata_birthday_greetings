package ch.example.kata.praemienrechner.model;

public enum AdditionalInsurance {
    ZAHN_MEDIZIN(30.0), SEH_HILFE(15.0), KOMPLEMENTAER_MEDIZIN(40.0);

    private final double adjustment;

    AdditionalInsurance(double adjustment) {
        this.adjustment = adjustment;
    }
    
    public double getAdjustment() {
        return adjustment;
    }
}
