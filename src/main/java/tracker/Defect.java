package tracker;

public class Defect {
    private static int idStart = 1;
    private final long id = idStart++;
    public String defectName;
    public DefectPriority defectPriority;
    public DefectStatus defectStatus;
    public int defectFixDays;
    private Attachment attachment;

    public Defect(String defectName, DefectPriority defectPriority, int defectFixDays, Attachment attachment) {
        this.defectName = defectName;
        this.defectPriority = defectPriority;
        this.defectFixDays = defectFixDays;
        this.attachment = attachment;
        this.defectStatus = DefectStatus.OPEN;
    }

    public Defect(String defectName, DefectPriority defectPriority, int defectFixDays) {
        this.defectName = defectName;
        this.defectPriority = defectPriority;
        this.defectFixDays = defectFixDays;
        this.defectStatus = DefectStatus.OPEN;

    }

    public String getIdInfo() {
        return "ID: " + id;
    }

    public Long getId() {
        return id;
    }

    public String getDefectNameInfo() {
        return " | Названиe дефекта: " + defectName;
    }

    public String getDefectPriorityInfo() {
        return " | Приоритет: " + defectPriority.getPriorityName();
    }

    public String getDefectStatusInfo() {
        return " | Статус: " + defectStatus.getDefectStatusName();
    }
    public void setStatus(DefectStatus defectStatus){
        this.defectStatus = defectStatus;
    }

    public String getDefectFixDaysInfo() {
        return " | Дней на исправление: " + defectFixDays;
    }

    public String getDefectInfo() {
        String defectInfo = getIdInfo() + getDefectNameInfo() + getDefectPriorityInfo() + getDefectStatusInfo() + getDefectFixDaysInfo();
        if (attachment != null) {
            defectInfo = defectInfo + attachment;
        }
        return defectInfo;
    }
}
