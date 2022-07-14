package tracker;

public class Defect {
    static long number = 1000000;
    final long id = number++;
    String resume;
    String priority;
    int days;

    public Defect(String resume, String priority, int days) {
        this.resume = resume;
        this.priority = priority;
        this.days = days;
    }

    public String getFields() {
        return id+" | "+resume+" | "+priority+" | "+days;
    }
}
