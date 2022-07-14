package tracker;

public class Defect {
    private final long id = number++;
    private String resume;
    private String priority;
    private int days;

    static int number = 1000000;

    public Defect(String resume, String priority, int days) {
        this.resume = resume;
        this.priority = priority;
        this.days = days;
    }

    public String getField() {
        return id + " | " + resume + " | " + priority + " | " + days;
    }
}
