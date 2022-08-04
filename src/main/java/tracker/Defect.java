package tracker;

public class Defect {
    private static long createIdDefect = 1000000;
    private final long ID;
    private final String resume;
    private String severity;
    private int days;
    private Attachment attachment;

    public Defect (String resume, String severity, int days, Attachment attachment) {
        this.resume = resume;
        this.severity = severity;
        this.days = days;
        this.attachment = attachment;
        ID = createIdDefect;
        createIdDefect++;
    }

    String getInfo () {
        return ("ID дефекта: " + ID + " Резюме дефекта: " + resume + " | " + "Критичность: " + severity +
                " | " + "Количество дней на исправление: " + days + "\n");
    }
}
