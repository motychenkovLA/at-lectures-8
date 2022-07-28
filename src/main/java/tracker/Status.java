package tracker;

public enum Status {
    OPEN("Открыт"),
    CLOSE("Закрыт"),
    IN_PROGRESS("В работе"),
    REVIEW("На анализе");
    String name;

    Status (String name) {
        this.name = name;
    }
}
