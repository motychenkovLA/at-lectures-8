package tracker;

public enum Status {
    OPEN("Открыт"),
    CLOSE("Закрыт"),
    IN_PROGRESS("В работе"),
    REVIEW("На анализе");

    private final String name;

    public String getName() {
        return name;
    }

    Status (String name) {
        this.name = name;
    }
}
