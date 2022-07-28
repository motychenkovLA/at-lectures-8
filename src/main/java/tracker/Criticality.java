package tracker;

public enum Criticality {
    High("High"),
    Low("Low"),
    Medium("Medium");
    private final String name;

    public String getName() {
        return name;
    }

    Criticality (String name) {
        this.name = name;
    }
}
