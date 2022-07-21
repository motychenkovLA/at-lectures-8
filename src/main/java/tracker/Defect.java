package tracker;

public class Defect {

    private static long counter = 1000000;
    private final long id;
    private final String description;
    private final String severity;
    private final int numberOfDays;

    public Defect (String description, String severity, int numberOfDays) {
        this.description = description;
        this.severity = severity;
        this.numberOfDays = numberOfDays;
        id = counter;
        counter++;
    }

    public String getInfoDefect (){
        return description + " // " + severity + " // "  + numberOfDays + " // " + id;
    }

}





