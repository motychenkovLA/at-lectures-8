package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        System.out.println("Введите критичность дефекта из списка : High, Low, Medium");
        String priority = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int days = scanner.nextInt();
        scanner.nextLine();
        final int WEEKDAY = 5;
        boolean workDays = days<=WEEKDAY;
        System.out.println(name + " " + priority + " " + days + " " + workDays);
    }
}
