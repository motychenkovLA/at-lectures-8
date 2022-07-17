package tracker;

public class Defect {
    private final long id = number++;
    private final String resume;
    private final String priority;
    private final int days;
    private final Attachment attachment;

    private static int number = 1000000;

    public Defect(String resume, String priority, int days, Attachment attachment) {
        this.resume = resume;
        this.priority = priority;
        this.days = days;
        this.attachment = attachment;
    }

    public String getField() {
        return id + " | " + resume + " | " + priority + " | " + days +" | "+attachment.asString();
    }
}
