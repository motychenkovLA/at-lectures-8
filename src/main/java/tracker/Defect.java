package tracker;

public class Defect {
    private final long id = number++;
    private final String resume;
    private Status status;
    private final int days;
    private final Attachment attachment;
    private final Criticality criticality;

    private static int number = 1000000;

    public Defect(String resume, Criticality criticality, int days, Attachment attachment) {
        this.resume = resume;
        this.criticality = criticality;
        this.days = days;
        this.attachment = attachment;
        this.status = Status.OPEN;
    }

    public long getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getField() {
        return id + " | " + resume + " | " + criticality.getName() + " | " + days + " | " + attachment.toString() + " | " + status.getName();
    }
}
