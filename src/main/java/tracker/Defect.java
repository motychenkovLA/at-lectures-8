package tracker;

public class Defect {

    long id;
    String description;
    String severity;
    int numberOfDays;

    void printInfoDefect (){
        System.out.println("Вы ввели следующий дефект: " +
                "\n" + description +
                "\n" + severity +
                "\n" + numberOfDays +
                "\n" + id);
    }

    String getInfoDefect (){
        return (description + " // " + severity + " // "  + numberOfDays + " // " + id);
    }

}
