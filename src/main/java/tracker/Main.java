package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean run = true;
        try (Scanner scanner = new Scanner(System.in)) {

            Repository repository = new Repository(20);

            while (run) {

                System.out.println("Что нужно сделать?\nadd - добавить новый дефект\n" +
                        "list - вывести список дефектов\nchange - изменить статус дефекта\nquit - выйти из программы");

                String userChoice = scanner.nextLine();

                switch (userChoice) {
                    case "add":
                        addDefect(repository, scanner);
                        break;
                    case "list":
                        listDefect(repository);
                        break;
                    case "change":
                        changeDefectStatus(repository, scanner);
                        break;
                    case "quit":
                        System.out.println("Выход из программы");
                        run = false;
                        break;
                    default:
                        System.out.println("Необходимо ввести одно из трех значений!\n");
                        break;
                }
            }
        }
    }
    private static void addDefect (Repository repository, Scanner scanner) {
        if (repository.getCountDefects() < repository.getDefectsLength()) {

            System.out.println("Введите резюме дефекта");
            String defectSummaryThisDefect = scanner.nextLine();

            System.out.println("Введите критичность дефекта из списка:");
            Severity[] valuesSeverity = Severity.values();
            for (Severity value : valuesSeverity) {
                System.out.println(value);
            }
            Severity defectSeverityThisDefect;
            while (true) {
                try {
                    defectSeverityThisDefect = Severity.valueOf(scanner.nextLine().toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Необходимо ввести критичность из списка!");
                }
            }
            System.out.println("Введите ожидаемое количество дней на исправление дефекта");
            int numberOfDaysThisDefect;
            while (true) {
                try {
                    numberOfDaysThisDefect = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Необходимо ввести число!");
                }
            }

            Status defectStatusThisDefect = Status.OPEN;

            System.out.println("Нужно добавить вложение?\n1 - Вложение не требуется\n" +
                    "2 - Вложение-комментарий\n3 - Вложение-ссылка на дефект");
            int typeAttachment;
            while (true) {
                try {
                    typeAttachment = Integer.parseInt(scanner.nextLine());
                    if (typeAttachment != 1 & typeAttachment != 2 & typeAttachment != 3)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Необходимо ввести число - 1, 2, 3");
                }
            }
            if (typeAttachment == 2) {
                System.out.println("Введите вложение-комментарий");
                CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                repository.add(new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, commentAttachment));
            } else if (typeAttachment == 3) {
                System.out.println("Введи вложение-ссылку на дефект");
                long defectAttach;
                while (true) {
                    try {
                        defectAttach = Long.parseLong(scanner.nextLine());
                        if (!repository.existenceOfSuchID(defectAttach))
                            throw new NumberFormatException("Нет такого ID");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Введите корреткный ID! Возможные варианты: ");
                        for (Defect defect : repository.getAll()) {
                            if (defect == null) {
                                break;
                            }
                            System.out.println(defect.getID());
                        }
                    }
                }
                DefectAttachment defectAttachment = new DefectAttachment(defectAttach);
                repository.add(new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, defectAttachment));
            } else {
                repository.add(new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect));
            }
            System.out.println("Дефект успешно добавлен" + "\n");

        } else {
            System.out.println("Невозможно добавить более " + repository.getDefectsLength() + " дефектов" + "\n");
        }
    }
    private static void listDefect (Repository repository) {
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
    }
    private static void changeDefectStatus (Repository repository, Scanner scanner) {
        if (repository.getCountDefects() == 0) {
            System.out.println("В системе нет ни одного дефекта\n");
        } else {
            System.out.println("Введите ссылку на дефект, для которого нужно изменить статус");
            long defectAttach;
            while (true) {
                try {
                    defectAttach = Long.parseLong(scanner.nextLine());
                    if (!repository.existenceOfSuchID(defectAttach)) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введите корреткный ID! Возможные варианты: ");
                    for (Defect defect : repository.getAll()) {
                        if (defect == null) {
                            break;
                        }
                        System.out.println(defect.getID());
                    }
                }
            }
            System.out.println("Введите новый статус из списка:");
            Status[] valuesStatus = Status.values();
            for (Status value : valuesStatus) {
                System.out.println(value);
            }
            Status defectStatus;
            while (true) {
                try {
                    defectStatus = Status.valueOf(scanner.nextLine().toUpperCase());
                    break;
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Необходимо ввести статус из списка!");
                }
            }
            for (Defect defect : repository.getAll()) {
                if (defect.getID() == defectAttach) {
                    defect.setDefectStatus(defectStatus);
                    System.out.println("Статус дефекта успешно изменен!\n");
                    break;
                }
            }
        }
    }
}