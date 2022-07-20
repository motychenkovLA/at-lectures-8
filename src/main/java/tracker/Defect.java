package tracker;

public class Defect {
    private static long id = 1000000;
    private final long objectId = id;
    private String resume;
    private String criticality;
    private int amountForCorrect;
    private Attachment attachment;
    private StatusDefect status = StatusDefect.OPEN;

    public Defect(String resume, String criticality, int amountForCorrect, Attachment attachment) {
        this.resume = resume;
        this.criticality = criticality;
        this.amountForCorrect = amountForCorrect;
        this.attachment = attachment;
        id++;
    }

    public void printCriticality() {
        for (Criticality criticalityDefect : Criticality.values()) {
            System.out.println(criticalityDefect);
        }
    }

    public long getId() {
        return objectId;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public int getAmountForCorrect() {
        return amountForCorrect;
    }

    public void setAmountForCorrect(int amountForCorrect) {
        this.amountForCorrect = amountForCorrect;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public StatusDefect getStatus() {
        return status;
    }

    public void setStatus(StatusDefect status) {
        this.status = status;
    }
}
