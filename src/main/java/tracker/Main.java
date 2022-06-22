package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String [] array = new String[10];
        Scanner scanner = new Scanner(System.in);
        boolean quit = true;
        int i = 0;
        while (quit) {
            System.out.println("Главное меню:  \nДобавить новый дефевкт - введите (add) \nВывести список дефектов - введите (list) \nВыйти из программы - введите (quit)");
            switch (scanner.nextLine()) {
                case "add":
                    if(i > 9) {
                        System.out.println("Вы ввели максимальное колличество дефектов");
                        System.out.println();
                        break;
                    }
                    System.out.println("Введите резюме дефекта");
                    String defect = scanner.nextLine();
                    System.out.println("Введите критичность дефекта из списка : High, Low, Medium");
                    String priority = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    array[i] = defect + " " + priority + " " + days;
                    i++;
                    break;
                case "list":
                    for(String element:array) {
                        System.out.println(element);
                    }
                    break;
                case "quit":
                    quit = false;
                default:
                    break;
            }
        }

    }
}
