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

                    System.out.println("Нужно добавить вложение?\n1 - Вложение не требуется\n" +
                            "2 - Вложение-комментарий\n3 - Вложение-ссылка на дефект");
                    int typeAttachment = scanner.nextInt();
                    scanner.nextLine();

                    if (typeAttachment == 2) {
                        System.out.println("Введите вложение-комментарий");
                        CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                        repository.add(new Defect(defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, commentAttachment));
                    } else if (typeAttachment == 3) {
                        System.out.println("Введи вложение-ссылку на дефект");
                        DefectAttachment defectAttachment = new DefectAttachment(scanner.nextLong());
                        repository.add(new Defect(defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, defectAttachment));
                    } else {
                        if (typeAttachment != 1) {
                            System.out.println("Тип вложение введен некорректно, вложение не будет добавлено!");
                        }
                        repository.add(new Defect(defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect));
                    }

                    System.out.println("Дефект успешно добавлен" + "\n");

                } else {
                    System.out.println("Невозможно добавить более " + repository.getDefectsLength() + " дефектов" + "\n");
                }
            } else if (userChoice.equals("list")) {
                if (repository.getCountDefects() == 0) {
                    System.out.println("В системе нет ни одного дефекта\n");
                } else {
                    for (Defect defect : repository.getAll()) {
                        if (defect == null) {
                            break;
                        }
                        System.out.println(defect.getInfo());
                    }
                    System.out.println();
                }
            } else if (userChoice.equals("quit")) {

                System.out.println("Выход из программы");
                break;
            } else {
                System.out.println("Необходимо ввести одно из трех значений!\n");
            }
        }
    }
}