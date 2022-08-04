package tracker;

public enum Status {
    OPEN,
    ASSIGNED,
    FIXED,
    VERIFIED,
    CLOSED;

    public static boolean existenceOfSuchStatus(Status defectStatus) {
        boolean statusExist = false;
        for (Status status : Status.values()) {
            if (status == defectStatus) {
                statusExist = true;
                break;
            }
        }
        return statusExist;
    }

}
