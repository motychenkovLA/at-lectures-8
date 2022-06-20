package tracker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите резюме дефекта.");
        Scanner scan = new Scanner (System.in);
        String resume = scan.nextLine();

        //ввод критичности дефекта с выбором.
        System.out.println("Введите критичность дефекта. \n Список вариантов: \n -Тривиальный \n -Незначительный \n -Значительный \n -Критический \n -Блокирующий");
        //System.out.print("Резюме дефекта: " + resume);
        String severity = scan.nextLine();

        System.out.println("Введите ожидаемое количество дней на исправление дефекта.");
        //System.out.print("Резюме дефекта: " + resume);
        int days = scan.nextInt();

        final int workingWeek=5;
        boolean week = workingWeek < days;

        System.out.print("Резюме дефекта: " + resume + "|" + "Критичность: " + severity + "|" + "количество дней на исправление: " + days + "|" + "займет больше рабочей недели: " + week);

    }
}