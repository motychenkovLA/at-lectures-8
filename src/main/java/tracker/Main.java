package tracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository(20);

        while (true) {

            System.out.println("Что нужно сделать?\nadd - добавить новый дефект\n" + "list - вывести список дефектов\nquit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();

            if (userChoice.equals("add")) {

                if (repository.getCountDefects() < repository.getDefectsLength()) {

                    System.out.println("Введите резюме дефекта");
                    String defectSummaryThisDefect = scanner.nextLine();

                    System.out.println("Введите критичность дефекта\nСписок вариантов:\nTrivial, Minor, Major, Critical, Blocker");
                    String defectSeverityThisDefect = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int numberOfDaysThisDefect = scanner.nextInt();

                    repository.add(new Defect(defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect));

                    System.out.println("Дефект успешно добавлен" + "\n");

                }
                else {
                    System.out.println("Невозможно добавить более " + repository.getDefectsLength()+ " дефектов"+"\n");
                }
            }
            else if (userChoice.equals("list")) {
                if (repository.getCountDefects() == 0) {
                    System.out.println ("В системе нет ни одного дефекта\n");
                }
                else {
                    for (Defect defect : repository.getAll()) {
                        if (defect == null) {
                            break;
                        }
                        System.out.println(defect.getInfo());
                    }
                    System.out.println();
                }
            }
            else if (userChoice.equals("quit")) {

                System.out.println("Выход из программы");
                break;
            }
            else {
                System.out.println ("Необходимо ввести одно из трех значений!\n");
            }
        }
    }
}