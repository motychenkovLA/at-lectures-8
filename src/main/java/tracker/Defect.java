package tracker;

public class Defect {

    private static long counter = 1000000; 
    private final long id = counter; // todo ? - лучше все-таки в конструкторе, чтоб не отрывать от counter++
    private final String description;
    private final String severity;
    private final int numberOfDays;

    public Defect (String description, String severity, int numberOfDays) {
        this.description = description;
        this.severity = severity;
        this.numberOfDays = numberOfDays;
        counter++;
    }

    // todo 3 - дефолтный модификатор доступа
    String getInfoDefect (){
        // todo 0 - скобки лишние
        return (description + " // " + severity + " // "  + numberOfDays + " // " + id);
    }

}





