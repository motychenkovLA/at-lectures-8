package tracker;

public class Defect {
    private final long id = number++;
    private final String resume;
    private Status status;
    private final int days;
    private final Attachment attachment;
    private final Criticality criticality;

    private static int number = 0; // todo 5 - дз 4 тз: ид дефектов начинаются с 1_000_000

    public Defect(String resume, Criticality criticality, int days, Attachment attachment) {
        this.resume = resume;
        this.criticality = criticality;
        this.days = days;
        this.attachment = attachment;
        this.status = Status.OPEN;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getField() {
        return id + " | " + resume + " | " + criticality + " | " + days + " | " + attachment.toString() + " | " + status;
    }
}
