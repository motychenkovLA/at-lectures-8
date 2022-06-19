package tracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String defectSummary = scanner.nextLine();

        System.out.println("Введите критичность дефекта\nСписок вариантов:\nTrivial, Minor, Major, Critical, Blocker");
        String defectSeverity = scanner.nextLine();

        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int numberOfDays = scanner.nextInt();

        boolean numberOfWorkDays = numberOfDays > 5;

        String defect = "Резюме: " + defectSummary + "\n" + "Критичность дефекта: " + defectSeverity + "\n" +
                "Количество дней на исправление: " + numberOfDays + "\n" + "Займет больше рабочей недели: " + numberOfWorkDays;

        System.out.println(defect);

    }
}