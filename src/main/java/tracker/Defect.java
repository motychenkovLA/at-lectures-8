package tracker;

public class Defect {
    private static long id = 300000;
    private final long objectId = id;
    private String resume;
    private Criticality criticality;
    private int amountForCorrect;
    private Attachment attachment;
    private DefectStatus status = DefectStatus.OPEN;

    public Defect(String resume, Criticality criticality, int amountForCorrect, Attachment attachment) {
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

    public Criticality getCriticality() {
        return criticality;
    }

    public void setCriticality(Criticality criticality) {
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

    public DefectStatus getStatus() {
        return status;
    }

    public void setStatus(DefectStatus status) {
        this.status = status;
    }
}