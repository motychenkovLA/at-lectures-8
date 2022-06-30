package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        final int MAX_BUGS_COUNT = 10;
        String[] bugDescription = new String[MAX_BUGS_COUNT];
        String[] bugCriticality = new String[MAX_BUGS_COUNT];
        int[] bugFixingTime = new int[MAX_BUGS_COUNT];

        boolean active = true;
        int bugId = 0;
        do {
            System.out.println("---Главное меню---");
            String menu = "Выберете команду:\n " +
                    "- добавить новый дефект (\"add\")\n " +
                    "- вывести список (\"list\")\n " +
                    "- выйти из программы (\"quit\") - главное меню";
            System.out.println(menu);
            String command = inputText.nextLine();
            switch (command) {
                //добавить дефект
                case "add":
                    if (bugId < 10) {
                        System.out.println("Хаюшки! Что у тебя за дефект?");
                        String bugName = inputText.nextLine();
                        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n"
                                + "low");
                        String bugLevel = inputText.nextLine();
                        System.out.println("Ожидаемый срок исправления в днях:");
                        int bugTime = inputText.nextInt();
                        inputText.nextLine();
                        int bugNumber = bugId + 1;
                        // todo 1 - хранить лучше только введенную информацию,
                        //  все форматирование и оформление делать только на выводе
                        // todo 0 - вообще сразу после ввода обратно выводить не требуется по ТЗ, тут на усмотрение
                        bugDescription[bugId]="Дефект №" + bugNumber + ":\n" + bugName + "\n";
                        bugCriticality[bugId]="Критичность - " + bugLevel + "\n";
                        bugFixingTime[bugId]=bugTime;
                        System.out.println(bugDescription[bugId] +
                                bugCriticality[bugId] +
                                "Срок исправления - " + bugFixingTime[bugId] + "\n");
                        bugId++;
                    } else {
                        System.out.println("Хватит дефектов!\n");
                    }
                    break;
                case "list":
                    if (bugId == 0) {
                        System.out.println("Пока нет дефектов\n");
                    } else {
                        System.out.println("Список дефектов:");
                        for (int i = 0; i < bugId; i++) {
                            System.out.println(bugDescription[i] +
                                    bugCriticality[i] +
                                    "Срок исправления - " + bugFixingTime[i] + "\n");
                        }
                        break;
                    }
                    // todo 5 - не break-ает если список пустой, в результаты выходит из программы
                    //выход
                case "quit":
                    active = false;
                    break;
            }
            // todo 1 - можно заменить на простой while
        } while (active);
    }
}
