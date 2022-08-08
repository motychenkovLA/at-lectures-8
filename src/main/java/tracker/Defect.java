package tracker;

public class Defect {


    private static long counter = 1000000;
    private final long id;
    private final String description;
    private final Severity severity;
    private final int numberOfDays;
    private final Attachment attachment;
    private Status status;

    public Defect (String description, Severity severity, int numberOfDays, Attachment attachment) {
        this.description = description;
        this.severity = severity;
        this.numberOfDays = numberOfDays;
        this.attachment = attachment;
        this.status = Status.OPEN;
        id = counter;
        counter++;
    }

    // todo 3 - это toString
    public String getInfoDefect (){
        return description + " // " + severity + " // " + numberOfDays + " // " + id + " // " + attachment.toString() + " // " + status;
    }

    public long getId() {
        return id;
    }

    public void setStatus (Status status){
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return id == defect.id &
                description.equals(defect.description) &
                severity.equals(defect.severity) &
                numberOfDays == defect.numberOfDays &
                attachment.equals(defect.attachment) &
                status.equals(defect.status);
    }

    // todo 3 - hash code ?
}





