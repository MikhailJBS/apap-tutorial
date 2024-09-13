package apap.tutorial.manpromanpro.model;

public enum Status {
    ON_GOING("On Going"),
    FINISHED("Finished");

    private final String displayValue;

    Status(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
