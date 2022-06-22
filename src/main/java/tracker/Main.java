package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int countBug = 10;
        String [] defect = new String[countBug];
        String [] priority = new String[countBug];
        int [] days = new int[countBug];
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
                    if(count > 9) {
                        System.out.println("Вы ввели максимальное колличество дефектов");
                        System.out.println();
                        break;
                    }
                    System.out.println("Введите резюме дефекта");
                    defect[count] = scanner.nextLine();
                    System.out.println("Введите критичность дефекта из списка : High, Low, Medium");
                    priority[count] = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    days[count] = scanner.nextInt();
                    scanner.nextLine();
                    count++;
                    break;
                case "list":
                    for(int i = 0;i < count;i++) {
                        System.out.println(defect[i]+" | "+priority[i]+" | "+days[i]);
                    }
                    break;
                case "quit":
                    run = false;
                default:
                    break;
            }
        }

    }
}
