package tracker;

public class Defects {
    private static int idStart = 1;
    private final long id = idStart++;
    public String defectName;
    public String defectPriority;
    public int defectFixDays;
    private Attachment attachment;
    public Defects (String defectName, String defectPriority, int defectFixDays, Attachment attachment) {
        this.defectName = defectName;
        this.defectPriority = defectPriority;
        this.defectFixDays = defectFixDays;
        this.attachment = attachment;
    }
    public Defects (String defectName, String defectPriority, int defectFixDays) {
        this.defectName = defectName;
        this.defectPriority = defectPriority;
        this.defectFixDays = defectFixDays;
    }

    public String getId(){
        return "ID: " + id;
    }
    public String getDefectName() {
        return " | Названиe дефекта: " + defectName;
    }

    public String getDefectPriority() {
        return " | Приоритет: " + defectPriority;
    }
    public String getDefectFixDays (){
        return " | Дней на исправление: " + defectFixDays;
    }
    public String getDefectInfo () {
        String defectInfo = getId() + getDefectName() + getDefectPriority() + getDefectFixDays();
        if (attachment != null){
            defectInfo = defectInfo + attachment.asString();
        }

        return defectInfo;
    }
}
