package ch.example.kata.praemienrechner.model;

public enum Canton {
    AG("Aargau"),
    AI("Appenzell Innerrhoden"),
    AR("Appenzell Ausserrhoden"),
    BE("Bern"),
    BL("Basel-Landschaft"),
    BS("Basel-Stadt"),
    FR("Freiburg"),
    GE("Genf"),
    GL("Glarus"),
    GR("Graubünden"),
    JU("Jura"),
    LU("Luzern"),
    NE("Neuenburg"),
    NW("Nidwalden"),
    OW("Obwalden"),
    SG("St. Gallen"),
    SH("Schaffhausen"),
    SO("Solothurn"),
    SZ("Schwyz"),
    TG("Thurgau"),
    TI("Tessin"),
    UR("Uri"),
    VD("Waadt"),
    VS("Wallis"),
    ZG("Zug"),
    ZH("Zürich");

    private final String fullName;

    Canton(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return name() + " - " + fullName;
    }
}

