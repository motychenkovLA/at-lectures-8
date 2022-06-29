package tracker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean run = true;
        final int COUNTOFDEFECTS = 1; //максимальное число хранимых дефектов в программе
        String[] resume = new String[COUNTOFDEFECTS]; //массив резюме дефекта
        String[] severity = new String[COUNTOFDEFECTS]; //массив критичности
        int[] days = new int[COUNTOFDEFECTS]; //массив кол-во дней на исправление
        int count = 0;

        while (run) {
            System.out.println("Введите команду для выбора действия. \n add - Добавить новый дефект." +
                    " \n list - Вывод списка дефектов. \n quit - Выход.");
            String choice = scan.nextLine();

            switch (choice) {
                case "add": {
                    if (count > (COUNTOFDEFECTS - 1)) {
                        System.out.print("Заведено максимальное количество дефектов. ");
                    } else {
                        System.out.println("Введите резюме дефекта:");
                        resume[count] = scan.nextLine();

                        System.out.println("Введите критичность дефекта. \n Список вариантов: \n 1 - Тривиальный " +
                                "\n 2 - Незначительный \n 3 - Значительный \n 4 - Критический \n 5 - Блокирующий");
                        severity[count] = scan.nextLine();

                        System.out.println("Введите ожидаемое количество дней на исправление дефекта.");
                        days[count] = scan.nextInt();
                        scan.nextLine();
                    }
                    count++;
                    break;
                }

                case "list": {
                    for (int i = 0; i < count; i++) {
                        System.out.print("Резюме дефекта: " + resume[i] + " | " + "Критичность: " + severity[i] +
                                " | " + "количество дней на исправление: " + days[i] + "\n");
                    }
                    break;
                }

                case "quit": {
                    run = false;
                    System.out.print("Вы вышли из главного меню. ");
                    break;
                }

                default: {
                    System.out.print("Неверно введена команда. ");
                    break;
                }
            }
        }
    }
}