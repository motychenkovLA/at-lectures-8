package tracker;

import java.util.Objects;

public class Defect {

    private static long contDefectID = 1000000;
    private final long ID = contDefectID;
    private Status defectStatus;
    private String defectSummary;
    private Severity defectSeverity;
    private int numberOfDays;
    private Attachment defectAttachment;

    public Defect (Status defectStatus, String defectSummary, Severity defectSeverity, int numberOfDays) {
        this.defectStatus = defectStatus;
        this.defectSummary = defectSummary;
        this.defectSeverity = defectSeverity;
        this.numberOfDays = numberOfDays;
        contDefectID++;
    }

    public Defect (Status defectStatus, String defectSummary, Severity defectSeverity, int numberOfDays, Attachment defectAttachment) {
        this (defectStatus, defectSummary, defectSeverity, numberOfDays);
        this.defectAttachment = defectAttachment;
    }


    public long getID() {
        return ID;
    }

    public Status getDefectStatus() {
        return defectStatus;
    }

    public String getDefectSummary() {
        return defectSummary;
    }

    public Severity getDefectSeverity() {
        return defectSeverity;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setDefectStatus(Status defectStatus) {
        this.defectStatus = defectStatus;
    }

    public void setDefectSummary(String defectSummary) {
        this.defectSummary = defectSummary;
    }

    public void setDefectSeverity(Severity defectSeverity) {
        this.defectSeverity = defectSeverity;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    String getInfo () {
        String info = this.ID + " | " + this.defectStatus + " | " + this.defectSummary + " | " + this.defectSeverity + " | " + this.numberOfDays;
        if (this.defectAttachment != null) {
            info = info + this.defectAttachment;
        }
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Defect)) return false;
        Defect defect = (Defect) o;
        return getID() == defect.getID() && getNumberOfDays() == defect.getNumberOfDays()
                && getDefectStatus() == defect.getDefectStatus() && Objects.equals(getDefectSummary(),
                defect.getDefectSummary()) && getDefectSeverity() == defect.getDefectSeverity() &&
                Objects.equals(defectAttachment, defect.defectAttachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getDefectStatus(), getDefectSummary(),
                getDefectSeverity(), getNumberOfDays(), defectAttachment);
    }
}
