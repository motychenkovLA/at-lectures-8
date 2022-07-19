package tracker;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean run = true;
        final int COUNTOFDEFECTS = 10; //максимальное число хранимых дефектов в программе
        Defect [] arrayOfDefects = new Defect[COUNTOFDEFECTS];
        long idDefect = 1000000;
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
                        String resume = scan.nextLine();

                        System.out.println("Введите критичность дефекта. \n Список вариантов: \n 1 - Тривиальный " +
                                "\n 2 - Незначительный \n 3 - Значительный \n 4 - Критический \n 5 - Блокирующий");
                        String severity = scan.nextLine();

                        System.out.println("Введите ожидаемое количество дней на исправление дефекта.");
                        int days = scan.nextInt();

                        long id = idDefect + count;
                        Defect defect = new Defect(id, resume, severity, days);
                        arrayOfDefects[count] = defect;
                    }
                    count++;
                    break;
                }

                case "list": {
                    for (int i = 0; i < count; i++) {
                        System.out.println(arrayOfDefects[i].getInfo());
                    }
                    break;
                }

                case "quit": {
                    run = false;
                    System.out.println("Вы вышли из главного меню. ");
                    break;
                }

                default: {
                    System.out.println("Неверно введена команда. ");
                    break;
                }
            }
        }
    }
}