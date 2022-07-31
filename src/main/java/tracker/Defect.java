package tracker;

public class Defect {
    private static long idDefect = 1000000;
    private final long id;
    private final String resume;
    private final String severity;
    private final int days;

    public Defect(String resume, String severity, int days) {
        this.resume = resume;
        this.severity = severity;
        this.days = days;
        id = idDefect;
        idDefect++;
    }

    String getInfo () {
        return ("ID дефекта: " + id + " Резюме дефекта: " + resume + " | " + "Критичность: " + severity +
                       " | " + "Количество дней на исправление: " + days + "\n");
    }
}
