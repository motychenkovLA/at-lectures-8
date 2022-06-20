package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String resume;
        String criticality;
        int amountDays;
        final int Length_Week = 5;
        boolean weekCorrect;
        System.out.println("Введите резюме дефекта:");
        Scanner scanner = new Scanner(System.in);
        resume = scanner.nextLine();
        System.out.println("Введите критичность дефекта (Highest, high, middle, low):");
        criticality = scanner.nextLine();
        System.out.println("Введите ожидамое количество дней на исправление дефекта");
        amountDays = scanner.nextInt();
        scanner.nextLine();
        weekCorrect = Length_Week < amountDays;
        System.out.println("Информация о дефекте: ");
        System.out.println("Резюме: " + resume + " | " + "Серьезность " + criticality +
                " | " + "Количество дней на исправление " + " | " +
                "Займет больше рабочей недели (true/false): " + weekCorrect);
    }
}
