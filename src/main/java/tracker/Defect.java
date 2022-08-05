package tracker;

public class Defect {
    private static long createIdDefect = 1000000;
    private final long ID;
    private final String resume;
    private String severity;
    private int days;
    private Attachment attachment;
    private Status status;

    public Defect (String resume, Severity severity, int days, Attachment attachment) {
        this.resume = resume;
        this.severity = String.valueOf(severity);
        this.days = days;
        this.attachment = attachment;
        this.status = Status.OPEN;
        ID = createIdDefect;
        createIdDefect++;
    }

    String getInfo () {
        return ("ID дефекта: " + ID + " Резюме дефекта: " + resume + " | " + "Критичность: " + severity +
                " | " + "Количество дней на исправление: " + days + "\n" + "Статус дефекта: " + status);
    }
    public long getID() {
        return ID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
