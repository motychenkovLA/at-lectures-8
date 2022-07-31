package tracker;

public class Defects {
    private static int idStart = 1;
    private final long id = idStart++;
    public String defectName;
    public String defectPriority;
    int defectFixDays;
    public Defects (String defectName, String defectPriority, int defectFixDays) {
        this.defectName = defectName;
        this.defectPriority = defectPriority;
        this.defectFixDays = defectFixDays;
    }
    public String getDefectInfo () {
        return "ID: " + id + " | Названиe дефекта: " + defectName + " | Приоритет: " + defectPriority +
                " | Дней на исправление: " + defectFixDays;
    }

}
