package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        final int MAX_BUGS_COUNT = 2;
        String[] bugDescription = new String[MAX_BUGS_COUNT];
        String[] bugCriticality = new String[MAX_BUGS_COUNT];
        int[] bugFixingTime = new int[MAX_BUGS_COUNT];

        boolean active = true;
        int bugId = 0;
        while (active){
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
                    if (bugId < MAX_BUGS_COUNT) {
                        System.out.println("Хаюшки! Что у тебя за дефект?");
                        String bugName = inputText.nextLine();
                        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n"
                                + "low");
                        String bugLevel = inputText.nextLine();
                        System.out.println("Ожидаемый срок исправления в днях:");
                        int bugTime = inputText.nextInt();
                        inputText.nextLine();
                        bugDescription[bugId]=bugName;
                        bugCriticality[bugId]=bugLevel;
                        bugFixingTime[bugId]=bugTime;
                        System.out.println("Ваш дефект:\n" + bugDescription[bugId] + "\n" +
                                "Критичность - " + bugCriticality[bugId] + "\n" +
                                "Срок исправления - " + bugFixingTime[bugId] + "\n");
                        bugId++;
                    } else {
                        System.out.println("Хватит дефектов!\n");
                    }
                    break;

                    //список
                case "list":
                    if (bugId == 0) {
                        System.out.println("Пока нет дефектов\n");
                    } else {
                        System.out.println("Список дефектов:");
                        for (int i = 0; i < bugId; i++) {
                            int bugNumber = i + 1;
                            System.out.println("Дефект №" + bugNumber + ":\n" + bugDescription[i] + "\n" +
                                    "Критичность - " + bugCriticality[i] + "\n" +
                                    "Срок исправления - " + bugFixingTime[i] + "\n");
                        }
                    }
                    break;
                    //выход
                case "quit":
                        active = false;
                        System.out.println("Bye-bye :)");
                        break;
        }
    }
}
}

