package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        String[] bugs = new String[10];
        boolean cycle = true;
        int i = 0;
        do {
            System.out.println("---Главное меню---");
            String menu = "Выберете команду:\n " +
                    "- добавить новый дефект (\"add\")\n " +
                    "- вывести список (\"list\")\n " +
                    "- выйти из программы (\"quit\") - главное меню";
            System.out.println(menu);
            String Command = inputText.nextLine();
            switch (Command) {
                //добавить дефект
                case "add":
                    if (i < 10) {
                        System.out.println("Хаюшки! Что у тебя за дефект?");
                        String bugName = inputText.nextLine();
                        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n"
                                + "low");
                        String bugLevel = inputText.nextLine();
                        System.out.println("Ожидаемый срок исправления в днях:");
                        int bugTime = inputText.nextInt();
                        inputText.nextLine();
                        final int WORKING_WEEK = 5;
                        int bugNumber = i + 1;
                        String bug = "Дефект №" + bugNumber + ":\n" + bugName + "\n" +
                                "Критичность - " + bugLevel + "\n" + "Срок исправления - " +
                                bugTime + "\n";
                        boolean enoughTime = bugTime <= WORKING_WEEK;
                        System.out.println(bug +
                                "Будет исправлено в течение рабочей недели (5 дн) - " +
                                enoughTime);
                        bugs[i] = bug;
                        i++;
                        final String EXIT = "quit";
                        String addedText;
                        do {
                            System.out.println("Выйдите в главное меню с помощью команды - quit");
                            addedText = inputText.next();
                        } while (!addedText.equals(EXIT));
                    } else {
                        //ошибка
                        System.out.println("Хватит дефектов!\n");
                    }
                    break;
                case "list":
                    if (i == 0) {
                        System.out.println("Пока нет дефектов\n");
                    } else {
                        System.out.println("Список дефектов:");
                        for (int j = 0; j < i; j++) {
                            System.out.println(bugs[j]);
                        }
                        break;
                    }
                    //выход
                case "quit":
                    break;
            }
        } while (cycle==true);
    }
}
