package tracker;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository(20);

        label:
        while (true) {

            System.out.println("Что нужно сделать?\nadd - добавить новый дефект\n" +
                    "list - вывести список дефектов\nchange - изменить статус дефекта\nquit - выйти из программы");

            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "add":

                    if (repository.getCountDefects() < repository.getDefectsLength()) {

                        System.out.println("Введите резюме дефекта");
                        String defectSummaryThisDefect = scanner.nextLine();

                        System.out.println("Введите критичность дефекта из списка:");
                        Severity[] valuesSeverity = Severity.values();
                        for (Severity value : valuesSeverity) {
                            System.out.println(value);
                        }
                        Severity defectSeverityThisDefect = Severity.valueOf(scanner.nextLine().toUpperCase());

                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        int numberOfDaysThisDefect = scanner.nextInt();

                        Status defectStatusThisDefect = Status.OPEN;

                        System.out.println("Нужно добавить вложение?\n1 - Вложение не требуется\n" +
                                "2 - Вложение-комментарий\n3 - Вложение-ссылка на дефект");
                        int typeAttachment = scanner.nextInt();
                        scanner.nextLine();

                        if (typeAttachment == 2) {
                            System.out.println("Введите вложение-комментарий");
                            CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                            repository.add(new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, commentAttachment));
                        } else if (typeAttachment == 3) {
                            System.out.println("Введи вложение-ссылку на дефект");
                            DefectAttachment defectAttachment = new DefectAttachment(scanner.nextLong());
                            repository.add(new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, defectAttachment));
                        } else {
                            if (typeAttachment != 1) {
                                System.out.println("Тип вложения введен некорректно, вложение не будет добавлено!");
                            }
                            repository.add(new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect));
                        }

                        System.out.println("Дефект успешно добавлен" + "\n");

                    } else {
                        System.out.println("Невозможно добавить более " + repository.getDefectsLength() + " дефектов" + "\n");
                    }
                    break;
                case "list":
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
                    break;
                case "change":
                    if (repository.getCountDefects() == 0) {
                        System.out.println("В системе нет ни одного дефекта\n");
                    } else {
                        System.out.println("Введите ссылку на дефект, для которого нужно изменить статус");
                        long defectAttach = scanner.nextLong();
                        if (!repository.existenceOfSuchID(defectAttach)) {
                            System.out.println("В репозитории нет дефекта с таким ID!\n");
                        } else {
                            System.out.println("Введите новый статус из списка:");
                            Status[] valuesStatus = Status.values();
                            for (Status value : valuesStatus) {
                                System.out.println(value);
                            }
                            scanner.nextLine();
                            Status defectStatus = Status.valueOf(scanner.nextLine().toUpperCase());
                            for (Defect defect : repository.getAll()) {
                                if (defect.getID() == defectAttach) {
                                    defect.setDefectStatus(defectStatus);
                                    System.out.println("Статус дефекта успешно изменен!\n");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    break label;

                default:
                    System.out.println("Необходимо ввести одно из трех значений!\n");
                    break;
            }
        }
    }
}