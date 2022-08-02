package tracker;

public enum DefectPriority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    CRITICAL("Критический");
    String PriorityName;

    DefectPriority(String criticalityName) {
        this.PriorityName = criticalityName;
    }

    public String getPriorityName() {
        return PriorityName;
    }

    public static void printPriorityNames() {
        for (DefectPriority defectPriority : DefectPriority.values()) {
            System.out.println(defectPriority);
        }
    }


//    public static boolean getDefectPriorityCheck(Scanner in) {
//        String defectPriority;
//
//        defectPriority = in.nextLine();
//                        if (LOW.PriorityName.equalsIgnoreCase(defectPriority)
//                                || MEDIUM.PriorityName.equalsIgnoreCase(defectPriority)
//                                || HIGH.PriorityName.equalsIgnoreCase(defectPriority)
//                                || CRITICAL.PriorityName.equalsIgnoreCase(defectPriority)) {
//                            return false;
//                        }
//        return true;
//    }
}