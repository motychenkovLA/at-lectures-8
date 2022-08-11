package tracker;

import java.util.Objects;

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
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return id == defect.id &&
                days == defect.days &&
                resume.equals(defect.resume) &&
                status.equals(defect.status) &&
                attachment.equals(defect.attachment) &&
                criticality.equals(defect.criticality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resume, status, days, attachment, criticality);
    }

    public String toString() {
        return id + " | " + resume + " | " + criticality.getName() + " | " + days + " | " + attachment.toString() + " | " + status.getName();
    }
}
