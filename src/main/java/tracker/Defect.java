package tracker;

public class Defect {

    private static long counter = 1000000;
    private final long id;
    private final String description;
    private final Severity severity;
    private final int numberOfDays;
    private final Attachment attachment;
    private Status status;

    public Defect (String description, Severity severity, int numberOfDays, Attachment attachment, Status status) {
        this.description = description;
        this.severity = severity;
        this.numberOfDays = numberOfDays;
        this.attachment = attachment;
        this.status = status; // todo 3 - ТЗ: "новые дефекты всегда имеют статус Открыто", с таким конструктором не выполняется
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
}





