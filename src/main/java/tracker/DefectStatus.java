package tracker;

public enum DefectStatus {
    OPEN("Открыт"),
    IN_WORK("На исправлении"),
    RETEST("Ретест"),
    DECLINED("Отклонен"),
    CLOSED("Закрыт");

    final String statusName;

    DefectStatus(String defectStatus) {
        this.statusName = defectStatus;
    }

    public String getDefectStatusName() {
        return statusName;
    }

    public static void printStatusNames() {
        for (DefectStatus defectStatus : DefectStatus.values()) {
            System.out.println(defectStatus);
        }
    }

}
