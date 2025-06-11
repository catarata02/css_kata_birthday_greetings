package ch.example.kata.praemienrechner;

public enum RisikoKategorie {
    GERINGES_RISIKO(1.0),
    MITTLERES_RISIKO(1.1),
    HOHES_RISIKO(1.3);

    private final double modifikator;

    RisikoKategorie(double modifikator) {
        this.modifikator = modifikator;
    }

    public double getModifikator() {
        return modifikator;
    }
}
