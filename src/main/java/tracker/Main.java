package tracker;

import java.util.Scanner;

public class Main {
    public static final String PRIORITY_LOW = "Low";
    public static final String PRIORITY_MEDIUM = "Medium";
    public static final String PRIORITY_HIGH = "High";
    public static final String PRIORITY_CRITICAL = "Critical";
    public static final int DEFECTS_AMOUNT_MAX = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] defectNames = new String[DEFECTS_AMOUNT_MAX];
        String[] defectPriorities = new String[DEFECTS_AMOUNT_MAX];
        int[] defectFixDays = new int[DEFECTS_AMOUNT_MAX];
        int defectsStored = 0;
        boolean programmIsOn = true;
        System.out.println("Добро пожаловать!");
        while (programmIsOn) {
            System.out.println();
            System.out.println("Для продолжения введите одну из команд:");
            System.out.println("1. Для добавления нового дефекта -\"/add\"");
            System.out.println("2. Для просмотра списка дефектов - \"/list\"");
            System.out.println("3. Для выхода из программы - \"/quit\"");
            String action = in.nextLine();
            switch (action) {
                case "/add":
                    if (defectsStored >= DEFECTS_AMOUNT_MAX) {
                        System.out.println("К сожалению, программа пока не может сохранить более 10 дефектов. Вы будете возвращены в главное меню.");
                        break;
                    }
                    System.out.print("Введите название дефекта: ");
                    String name = in.nextLine();
                    defectNames[defectsStored] = name;
                    String priorityInput = "";
                    boolean isPriorityIncorrect = true;
                    while (isPriorityIncorrect) {
                        System.out.printf("Введите приоритет дефекта ( %s, %s, %s, %s): ", PRIORITY_LOW, PRIORITY_MEDIUM, PRIORITY_HIGH, PRIORITY_CRITICAL);
                        priorityInput = in.nextLine();
                        if (PRIORITY_LOW.equalsIgnoreCase(priorityInput)
                                || PRIORITY_MEDIUM.equalsIgnoreCase(priorityInput)
                                || PRIORITY_HIGH.equalsIgnoreCase(priorityInput)
                                || PRIORITY_CRITICAL.equalsIgnoreCase(priorityInput)) {
                            isPriorityIncorrect = false;
                        }
                        defectPriorities[defectsStored] = priorityInput;
                    }
                    System.out.print("Введите количество дней на исправление дефекта: ");
                    int numDays = in.nextInt();
                    defectFixDays[defectsStored] = numDays;
                    in.nextLine();
                    String defectSummary = String.format("Название: %s | Приоритет: %s | Дней на исправление: %d", name, priorityInput, numDays);
                    System.out.println(defectSummary);
                    defectsStored++;
                    break;
                case "/list":
                    System.out.println("Список дефектов:");
                    for (int i = 0; i < defectsStored; i++) {
                        System.out.println("Названиe дефекта: " + defectNames[i] + " | Название приоритета: " + defectPriorities[i] + " | Дней на исправление: " + defectFixDays[i]);
                    }
                    break;
                case "/quit":
                    programmIsOn = false;
                    System.out.println("Вы вышли из программы. До скорой встречи! :)");
                    break;
                default:
                    System.out.println("Упс!");
                    System.out.println("Укажите одну из предложенных команд - другие я пока исполнять не умею :(");
                    break;
            }
        }
    }
}
