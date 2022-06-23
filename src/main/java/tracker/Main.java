package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_DEFECT_COUNT = 10;
        String[] resumeDefects = new String[MAX_DEFECT_COUNT];
        String[] criticalityDefects = new String[MAX_DEFECT_COUNT];
        int[] amountDaysDefects = new int[MAX_DEFECT_COUNT];
        boolean isRun = true;
        int amountDefects = 0;
        while (isRun) {
            System.out.println("Выберите действие: добавить новый дефект (\"add\"), " +
                    "вывести список (\"list\"), выйти из программы (\"quit\") - главное меню");
            String userDo = scanner.nextLine();
                if (userDo.equals("add")) {
                    if (amountDefects < MAX_DEFECT_COUNT) {
                        String resume;
                        String criticality;
                        int amountDays;
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
                        resumeDefects[amountDefects] = resume;
                        criticalityDefects[amountDefects] = criticality;
                        amountDaysDefects[amountDefects] = amountDays;
                        amountDefects++;
                    } else {
                        System.out.println("Закончилось место, невозможно ввести новый дефект");
                    }
                } else if (userDo.equals("list")) {
                    for (int i = 0; i < amountDefects; i++) {
                        System.out.println(resumeDefects[i]);
                        System.out.println(criticalityDefects[i]);
                        System.out.println(amountDaysDefects[i]);
                    }
                } else if (userDo.equals("quit")) {
                    isRun = false;
                } else {
                    System.out.println("Введите корректное значение");
                }
            }
        }
    }

