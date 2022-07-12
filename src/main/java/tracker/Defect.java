package tracker;

public class Defect {
    long id;
    String resume;
    String priority;
    int days;

    static int number = 1000000;

    public Defect(String resume, String priority, int days) {
        this.resume = resume;
        this.priority = priority;
        this.days = days;
        id = number++;
    }

    String getDefects() {
        return id + " | " + resume + " | " + priority + " | " + days;
    }
}
