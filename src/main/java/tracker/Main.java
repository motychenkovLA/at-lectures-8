package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название дефекта: ");
        String name = in.nextLine();
        String pLow = "Low";
        String pMedium = "Medium";
        String pHigh = "High";
        String pCritical = "Critical";
        System.out.printf("Введите приоритет дефекта ( %s, %s, %s, %s): ", pLow ,pMedium ,pHigh ,pCritical);
        String priority = in.nextLine();
        System.out.print("Введите количество дней на исправление дефекта: ");
        int numDays = in.nextInt();
        int workDays = 5;
        Boolean evaluation = numDays > workDays;
        System.out.printf("Название: %s | Приоритет: %s | Дней на исправление: %d | Исправление займет больше недели? Ответ: %b", name, priority, numDays, evaluation);
        System.exit(0);

    }
}
