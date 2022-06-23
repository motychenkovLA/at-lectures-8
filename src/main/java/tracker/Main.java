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
        int i = 0;
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
                    if (i < 10) {
                        defects[i] = resume;
                        i++;
                    } else {
                        System.out.println("Закончилось место, невозможно ввести новый дефект");
                    }
                } else if (userDo.equals("list")) {
                    System.out.println(Arrays.toString(defects));
                } else if (userDo.equals("quit")) {
                    run = false;
                } else {
                    System.out.println("Введите корректное значение");
                }
            }
        }
    }

