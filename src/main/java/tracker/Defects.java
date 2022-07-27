package tracker;

public class Defects {
    private static int idStart = 1000000;
    private final long id = idStart++;
    private final String defectName;
    private final String defectPriority;
    private final int defectFixDays;
    public Defects (String defectName, String defectPriority, int defectFixDays) {
        this.defectName = defectName;
        this.defectPriority = defectPriority;
        this.defectFixDays = defectFixDays;
    }
    String getDefectInfo () {
        return "ID: " + id + " | Названиe дефекта: " + defectName + " | Приоритет: " + defectPriority + " | Дней на исправление: " + defectFixDays;
    }

}
