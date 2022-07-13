package tracker;

public class Defect {

    private static long contDefectID = 1000000;
    private final long ID = contDefectID;
    private String defectSummary;
    private String defectSeverity;
    private int numberOfDays;

    public Defect (String defectSummary, String defectSeverity, int numberOfDays) {
        this.defectSummary = defectSummary;
        this.defectSeverity = defectSeverity;
        this.numberOfDays = numberOfDays;
        contDefectID++;
    }

    public long getID() {
        return ID;
    }

    public String getDefectSummary() {
        return defectSummary;
    }

    public String getDefectSeverity() {
        return defectSeverity;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setDefectSummary(String defectSummary) {
        this.defectSummary = defectSummary;
    }

    public void setDefectSeverity(String defectSeverity) {
        this.defectSeverity = defectSeverity;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    String getInfo () {
        return this.ID + " | " + this.defectSummary + " | " +this.defectSeverity + " | " + numberOfDays;
    }
}
