package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // todo 3 - тут хранится не сам дефект (резюме, приор, дни), а его строковое представление
        // todo 3 - 10 это константа
        String [] array = new String[10];
        Scanner scanner = new Scanner(System.in);
        // todo 0 - называется quit, но при этом пока true программа наоборот не выходит
        boolean quit = true;
        // todo 0 - не говорящее название
        int i = 0;
        while (quit) {
            // todo 1 - за 120 символов (белая лингия в идее) лучше не вылезать, за монитор тем более, надо бы перенести
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
                    // todo 3 - выводит кучу null-ов кроме дефектов
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
