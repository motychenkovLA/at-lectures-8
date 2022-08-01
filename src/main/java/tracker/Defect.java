package tracker;

public class Defect {

    private static long counter = 1000000;
    private final long id;
    private final String description;
    private final String severity;
    private final int numberOfDays;
    private final Attachment attachment;

    public Defect (String description, String severity, int numberOfDays, Attachment attachment) {
        this.description = description;
        this.severity = severity;
        this.numberOfDays = numberOfDays;
        this.attachment = attachment;
        id = counter;
        counter++;
    }
    public String getInfoDefect (){
        return description + " // " + severity + " // " + numberOfDays + " // " + id + " // " + attachment.asString();
    }
}





