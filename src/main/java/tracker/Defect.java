package tracker;

import java.util.Objects;

public class Defect {
    private static long lastId = 1000000;
    private final long id = lastId++;
    private String resume;
    private Criticality criticality;
    private int amountForCorrect;
    private Attachment attachment;
    private StatusDefect status = StatusDefect.OPEN;

    public Defect(String resume, Criticality criticality, int amountForCorrect, Attachment attachment) {
        this.resume = resume;
        this.criticality = criticality;
        this.amountForCorrect = amountForCorrect;
        this.attachment = attachment;
    }

    public long getId() {
        return id;
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

    public StatusDefect getStatus() {
        return status;
    }

    public void setStatus(StatusDefect status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return id == defect.id
                && amountForCorrect == defect.amountForCorrect
                && resume.equals(defect.resume)
                && criticality == defect.criticality
                && attachment.equals(defect.attachment)
                && status == defect.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resume, criticality, amountForCorrect, attachment, status);
    }

    @Override
    public String toString() {
        return "Defect{" +
                "id=" + id +
                ", resume='" + resume + '\'' +
                ", criticality=" + criticality +
                ", amountForCorrect=" + amountForCorrect +
                ", attachment=" + attachment +
                ", status=" + status +
                '}';
    }
}
