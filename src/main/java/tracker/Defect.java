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

    public String getInfoDefect (){
        return description + " // " + severity + " // " + numberOfDays + " // " + id + " // " + attachment.toString() + " // " + status;
    }

    public long getId() {
        return id;
    }

    public void setStatus (Status status){
        this.status = status;
    }

    // todo 3 - ТЗ: реализовать методы equals(...) и hashCode() у Defect
}





