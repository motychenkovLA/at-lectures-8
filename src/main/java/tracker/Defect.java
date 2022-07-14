package tracker;

public class Defect {

    long id;
    String description;
    String severity;
    int numberOfDays;

    // todo 3 - Defect работает с консолью, а должен моделировать дефект
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
