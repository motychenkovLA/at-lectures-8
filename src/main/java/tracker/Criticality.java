package tracker;

public enum Criticality {
    // todo 1 - не по код стайлу
    High("Высокий"),
    Low("Низкий"),
    Medium("Средний");
    String name; // todo 3 - не приватное, не финальное

    Criticality (String name) {
        this.name = name;
    }
}
