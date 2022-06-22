package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int COUNT_BUG = 10;
        String [] resumes = new String[COUNT_BUG];
        String [] priorities = new String[COUNT_BUG];
        int [] days = new int[COUNT_BUG];
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int count = 0;
        while (run) {
            System.out.println("Главное меню:  " +
                    "\nДобавить новый дефевкт - введите (add) " +
                    "\nВывести список дефектов - введите (list) " +
                    "\nВыйти из программы - введите (quit)");
            switch (scanner.nextLine()) {
                case "add":
                    if(count >= COUNT_BUG) {
                        System.out.println("Вы ввели максимальное колличество дефектов");
                        System.out.println();
                        break;
                    }
                    System.out.println("Введите резюме дефекта");
                    resumes[count] = scanner.nextLine();
                    System.out.println("Введите критичность дефекта из списка : High, Low, Medium");
                    priorities[count] = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    days[count] = scanner.nextInt();
                    scanner.nextLine();
                    count++;
                    break;
                case "list":
                    for(int i = 0;i < count;i++) {
                        System.out.println(resumes[i]+" | "+priorities[i]+" | "+days[i]);
                    }
                    break;
                case "quit":
                    run = false;
                    break;
                default:
                    break;
            }
        }

    }
}
