package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Главное меню:  " +
                    "\nДобавить новый дефевкт - введите (add) " +
                    "\nВывести список дефектов - введите (list) " +
                    "\nВыйти из программы - введите (quit)");
            switch (scanner.nextLine()) {
                case "add":
                    if (repository.maxCount()) {
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
                        if (def != null)
                            System.out.println(def.getFields());
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
