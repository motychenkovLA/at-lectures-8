package tracker;

public enum Criticality {
    HIGH("Высокий"),
    LOW("Низкий"),
    MEDIUM("Средний");
    private final String name;

    public String getName() {
        return name;
    }

    Criticality (String name) {
        this.name = name;
    }
}
