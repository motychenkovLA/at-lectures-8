package tracker;

public enum Status {
    OPEN("Открыт"),
    CLOSE("Закрыт"),
    IN_PROGRESS("В работе"),
    REVIEW("На анализе");
    String name;// todo 3 - не приватное, не финальное

    Status (String name) {
        this.name = name;
    }
}
