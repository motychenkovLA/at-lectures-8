package tracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int MAX_AMOUNT_DEFECT = 10;
        Defect[] defects = new Defect[MAX_AMOUNT_DEFECT];
        int countDefects = 0;

        while (true) {

            System.out.println("Что нужно сделать?\nadd - добавить новый дефект\n" + "list - вывести список дефектов\nquit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();

            if (userChoice.equals("add")) {

                if (countDefects < MAX_AMOUNT_DEFECT) {

                    System.out.println("Введите резюме дефекта");
                    String defectSummaryThisDefect = scanner.nextLine();

                    System.out.println("Введите критичность дефекта\nСписок вариантов:\nTrivial, Minor, Major, Critical, Blocker");
                    String defectSeverityThisDefect = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int numberOfDaysThisDefect = scanner.nextInt();

                    defects[countDefects] = new Defect(1000000+countDefects, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect);

                    System.out.println("Дефект успешно добавлен" + "\n");

                    countDefects++;
                }
                else {
                    System.out.println("Невозможно добавить более 10 дефектов"+"\n");
                }
            }
            else if (userChoice.equals("list")) {
                if (countDefects == 0) {
                    System.out.println ("В системе нет ни одного дефекта\n");
                }
                else {
                    for (int i=0; i<countDefects; i++) {
                        System.out.println(defects[i].getInfo());
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