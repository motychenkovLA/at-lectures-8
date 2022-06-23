package tracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] defectSummary = new String[10];
        String[] defectSeverity = new String[10];
        int[] numberOfDays = new int[10];
        int countDefects = 0;

        while (true) {

            System.out.println("Что нужно сделать?\nadd - добавить новый дефект\n" + "list - вывести список дефектов\nquit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();

            if (userChoice.equals("add")) {

                if (countDefects < 10) {

                    System.out.println("Введите резюме дефекта");
                    String defectSummaryThisDefect = scanner.nextLine();

                    System.out.println("Введите критичность дефекта\nСписок вариантов:\nTrivial, Minor, Major, Critical, Blocker");
                    String defectSeverityThisDefect = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int numberOfDaysThisDefect = scanner.nextInt();

                    defectSummary[countDefects] = defectSummaryThisDefect;
                    defectSeverity[countDefects]= defectSeverityThisDefect;
                    numberOfDays[countDefects] = numberOfDaysThisDefect;

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
                        System.out.println(defectSummary[i]+ " | " +defectSeverity[i]+ " | " +numberOfDays[i]);
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