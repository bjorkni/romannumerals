package be.kapture.romannumerals;

public enum Roman {
    // Note: these numerals MUST be declared in ascending order. TODO (could be fixed by not using ordinals)
    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L", 50),
    C("C", 100),
    D("D", 500),
    M("M", 1000),
    V_("V_", 5000); // Going above M (1000) is not conventional, but is possible just by expanding the enum.

    private String representation;
    private int decimalValue;

    Roman(String representation, int decimalValue) {
        this.representation = representation;
        this.decimalValue = decimalValue;
    }

    public String representation() {
        return representation;
    }

    public int value() {
        return decimalValue;
    }

    public Roman getOneLower() {
        return Roman.values()[ordinal() - 1];
    }

    public Roman getOneHigher() {
        return Roman.values()[ordinal() + 1];
    }

    public Roman getTwoHigher() {
        return Roman.values()[ordinal() + 2];
    }

    public boolean isaFive() {
        return String.valueOf(value()).startsWith("5");
    }

    public static Roman getHighest() {
        return Roman.values()[Roman.values().length - 1];
    }

    public static int getHighestRepresentableValue() {
        Roman highest = getHighest();

        if (highest.isaFive()) {
            return (highest.value() * 2 - highest.getOneLower().value()) - 1;
        }
        return (highest.value() * 4) - 1;
    }

}
