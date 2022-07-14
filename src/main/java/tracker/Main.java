package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int COUNT_BUG = 10;
        Repository repository = new Repository(COUNT_BUG);
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Главное меню:  " +
                    "\nДобавить новый дефевкт - введите (add) " +
                    "\nВывести список дефектов - введите (list) " +
                    "\nВыйти из программы - введите (quit)");
            switch (scanner.nextLine()) {
                case "add":
                    if (repository.full()) {
                        System.out.println("Вы ввели максимальное колличество дефектов");
                        System.out.println();
                        break;
                    }
                    System.out.println("Введите резюме дефекта");
                    String resumes = scanner.nextLine();
                    System.out.println("Введите критичность дефекта из списка : High, Low, Medium");
                    String priorities = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int days = scanner.nextInt();
                    scanner.nextLine();

                    Defect defect = new Defect(resumes, priorities, days);
                    repository.add(defect);
                    break;
                case "list":
                    for (Defect def : repository.getAll()) {
                        System.out.println(def.getField());
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
