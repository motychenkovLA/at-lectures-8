package tracker;

public class Defect {

    private static long counter = 1000000; 
    private final long id = counter;
    private final String description;
    private final String severity;
    private final int numberOfDays;

    public Defect (String description, String severity, int numberOfDays) {
        this.description = description;
        this.severity = severity;
        this.numberOfDays = numberOfDays;
        counter++;
    }

    String getInfoDefect (){
        return (description + " // " + severity + " // "  + numberOfDays + " // " + id);
    }

}





