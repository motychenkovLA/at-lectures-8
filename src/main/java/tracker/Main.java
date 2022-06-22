package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] defects = new String[10];
        String resume;
        String criticality;
        int amountDays;
        boolean run = true;
        while (run) {
            System.out.println("Выберите действие: добавить новый дефект (\"add\"), " +
                    "вывести список (\"list\"), выйти из программы (\"quit\") - главное меню");
            String userDo = scanner.nextLine();
            if (userDo.equals("add")) {
                System.out.println("Введите резюме дефекта");
                resume = scanner.nextLine();
                System.out.println("Введите критичность дефекта (Highest, high, middle, low):");
                criticality = scanner.nextLine();
                System.out.println("Введите ожидамое количество дней на исправление дефекта");
                amountDays = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Информация о дефекте: ");
                System.out.println("Резюме: " + resume + " | " + "Серьезность " + criticality +
                        " | " + "Количество дней на исправление " + amountDays);
                int i = 0;
                defects[i] = resume;
                i++;
                run = true;
                    if (i > defects.length) {
                        System.out.println("Невозможно ввести новый дефект");
                        run = true;
                    }

            } else if (userDo.equals("list")) {
                System.out.println(Arrays.toString(defects));
                run = true;
            } else if (userDo.equals("quit")) {
                run = true;
            } else {
                System.out.println("Введите корректное значение");
                run = true;
            }

        }
    }
}
