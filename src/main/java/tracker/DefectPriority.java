package tracker;

public enum DefectPriority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    CRITICAL("Критический");
    final String PriorityName;

    DefectPriority(String defectPriority) {
        this.PriorityName = defectPriority;
    }

    public String getPriorityName() {
        return PriorityName;
    }

    public static void printPriorityNames() {
        for (DefectPriority defectPriority : DefectPriority.values()) {
            System.out.println(defectPriority);
        }
    }
}