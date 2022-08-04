package tracker;

public enum Severity {
    TRIVIAL,
    MINOR,
    MAJOR,
    CRITICAL,
    BLOCKER;

    public static boolean existenceOfSuchSeverity(Severity defectSeverity) {
        boolean severityExist = false;
        for (Severity severity : Severity.values()) {
            if (severity == defectSeverity) {
                severityExist = true;
                break;
            }
        }
        return severityExist;
    }

}

