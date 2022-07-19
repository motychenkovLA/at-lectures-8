package tracker;

public class Defect {
    long id;
    String resume;
    String severity;
    int days;

    public Defect(long id, String resume, String severity, int days) {
        this.id = id;
        this.resume = resume;
        this.severity = severity;
        this.days = days;
    }

    String getInfo () {
        return ("ID дефекта: " + id + " Резюме дефекта: " + resume + " | " + "Критичность: " + severity +
                       " | " + "Количество дней на исправление: " + days + "\n");
    }
}
