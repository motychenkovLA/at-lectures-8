package tracker;

public enum Criticality {
    High("Высокий"),
    Low("Низкий"),
    Medium("Средний");
    String name;

    Criticality (String name) {
        this.name = name;
    }
}
