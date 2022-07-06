package tracker;

public class Defect {

    long ID;
    String defectSummary;
    String defectSeverity;
    int numberOfDays;

    public Defect (long ID, String defectSummary, String defectSeverity, int numberOfDays) {
        this.ID = ID;
        this.defectSummary = defectSummary;
        this.defectSeverity = defectSeverity;
        this.numberOfDays = numberOfDays;
    }

    String getInfo () {
        return this.ID + " | " + this.defectSummary + " | " +this.defectSeverity + " | " + numberOfDays;
    }
}
