package tracker;

public class Defect {

    long id;
    String description;
    String severity;
    int numberOfDays;

    public Defect (String description, String severity, int numberOfDays, long id) {
        this.description = description;
        this.severity = severity;
        this.numberOfDays = numberOfDays;
        this.id = id;
    }

    String getInfoDefect (){
        return (description + " // " + severity + " // "  + numberOfDays + " // " + id);
    }
}



