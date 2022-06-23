package tracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] bugArray = new String[10];

        while (true) {

            System.out.println("Что нужно сделать?\nadd - добавить новый дефект\n" + "list - вывести список дефектов\nquit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();

            if (userChoice.equals("add")) {

                boolean addDefectToArray = false;

                for (int i = 0; i < bugArray.length; i++) {

                    if (bugArray[i] == null) {
                        System.out.println("Введите резюме дефекта");
                        String defectSummary = scanner.nextLine();

                        System.out.println("Введите критичность дефекта\nСписок вариантов:\nTrivial, Minor, Major, Critical, Blocker");
                        String defectSeverity = scanner.nextLine();

                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        int numberOfDays = scanner.nextInt();

                        bugArray[i] = defectSummary + " | " + defectSeverity + " | " + numberOfDays;

                        addDefectToArray = true;

                        System.out.println("Дефект успешно добавлен" + "\n");
                        break;
                    }
                }
                if (!addDefectToArray) {
                    System.out.println("Невозможно добавить более "+bugArray.length+" дефектов"+"\n");
                }
            }
            else if (userChoice.equals("list")) {

                int amountNull = 0;

                for (String defect : bugArray) {
                    if (defect == null) {
                        amountNull++;
                    }
                }
                if (amountNull == bugArray.length) {
                    System.out.println ("В системе нет ни одного дефекта\n");
                    }
                else {
                    System.out.println("Список дефектов:");
                    for (String defect : bugArray) {
                        if (defect != null)
                            System.out.println(defect);
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