package tracker;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean run = true;
        final int COUNTOFDEFECTS = 10; //максимальное число хранимых дефектов в программе
        Repository repository = new Repository(COUNTOFDEFECTS);

        while (run) {
            System.out.println("Введите команду для выбора действия. \n add - Добавить новый дефект." +
                    " \n list - Вывод списка дефектов. \n quit - Выход.");
            String choice = scan.nextLine();

            switch (choice) {
                case "add": {
                    if (repository.addNewDefect()) {

                        System.out.println("Введите резюме дефекта:");
                        String resume = scan.nextLine();

                        System.out.println("Введите критичность дефекта. \n Список вариантов: \n 1 - Тривиальный " +
                                "\n 2 - Незначительный \n 3 - Значительный \n 4 - Критический \n 5 - Блокирующий");
                        String severity = scan.nextLine();

                        System.out.println("Введите ожидаемое количество дней на исправление дефекта.");
                        int days = scan.nextInt();
                        scan.nextLine();
                        Defect defect = new Defect(resume, severity, days);
                        repository.add(defect);
                    }
                    else {
                        System.out.print("Заведено максимальное количество дефектов. ");
                    }
                    break;
                }

                case "list": {
                    Defect [] defectsArray = repository.getAll();
                    for (Defect defForOut: defectsArray) {
                        System.out.println(defForOut.getInfo());
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