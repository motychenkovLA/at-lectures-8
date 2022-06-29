package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] bugs = new String[10];
        int bugsAmount = 0;

        do {
            System.out.println();
            System.out.println("-- Главное меню --");
            System.out.println("Добавьте новый деффект(add), посмотрите список дефектов(list) или выйдите из программы(quit):");
            String userInput = scanner.nextLine();

            if (userInput.equals("add")) { // Проверяем что юзер ввёл: add
                // Обрабатываем add
                if (bugsAmount < 10) {
                    System.out.println("Введите имя деффекта:");
                    String userInput2 = scanner.nextLine();
                    bugs[bugsAmount] = userInput2;
                    bugsAmount++;
                } else {
                    System.out.println("Слишком много багов!");
                }
            } else if (userInput.equals("list")) { // Проверяем что юзер ввёл: list
                // Обрабатываем List
                for (String bug: bugs) { // Проходим по массиву bugs для вывода багов
                    if (bug != null) { // Проверяем, если баг есть в текущем индексе, то выводим его
                        System.out.println(bug);
                        System.out.println();
                    }
                }
            } else if (userInput.equals("quit")) { // Проверяем что юзер ввёл: quit
                // Обрабатываем Quit
                break;
            }
        } while (true);
    }
}

