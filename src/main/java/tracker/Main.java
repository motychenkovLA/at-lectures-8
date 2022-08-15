package tracker;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean run = true;
        try (Scanner scanner = new Scanner(System.in)) {

            Map<Long, Defect> repository = new HashMap<>();

            while (run) {

                System.out.println("Что нужно сделать?\nadd - добавить новый дефект\n" +
                        "list - вывести список дефектов\nchange - изменить статус дефекта\nstats - вывести статистику\nquit - выйти из программы\"");

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
                    case "stats":
                        showStatistics(repository);
                        break;
                    case "quit":
                        System.out.println("Выход из программы");
                        run = false;
                        break;
                    default:
                        System.out.println("Необходимо ввести одно из пяти значений!\n");
                        break;
                }
            }
        }
    }
    private static void addDefect (Map<Long, Defect> repository, Scanner scanner) {

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
            Defect defect = new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, commentAttachment);
            repository.put(defect.getID(), defect);
        } else if (typeAttachment == 3) {
            if (repository.isEmpty()) {
                System.out.println("В системе нет ни одного дефекта, ссылка на дефект не будет добавлена!\n");
                Defect defect = new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect);
                repository.put(defect.getID(), defect);
            } else {
                System.out.println("Введите вложение-ссылку на дефект");
                long defectAttach;
                while (true) {
                    try {
                        defectAttach = Long.parseLong(scanner.nextLine());
                        if (!repository.containsKey(defectAttach))
                            throw new NumberFormatException();
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Введите корреткный ID! Возможные варианты: ");
                        for (Long defectKey : repository.keySet()) {
                            System.out.println(defectKey);
                        }
                    }
                }
                DefectAttachment defectAttachment = new DefectAttachment(defectAttach);
                Defect defect = new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect, defectAttachment);
                repository.put(defect.getID(), defect);
            }
        } else {
                Defect defect = new Defect(defectStatusThisDefect, defectSummaryThisDefect, defectSeverityThisDefect, numberOfDaysThisDefect);
                repository.put(defect.getID(), defect);
            }
            System.out.println("Дефект успешно добавлен" + "\n");
        }

    private static void listDefect (Map<Long, Defect> repository) {
        if (repository.isEmpty()) {
            System.out.println("В системе нет ни одного дефекта\n");
        } else {
            for (Defect defect : repository.values()) {
                System.out.println(defect.getInfo());
            }
            System.out.println();
        }
    }
    private static void changeDefectStatus (Map<Long, Defect> repository, Scanner scanner) {
        if (repository.isEmpty()) {
            System.out.println("В системе нет ни одного дефекта\n");
        } else {
            System.out.println("Введите ссылку на дефект, для которого нужно изменить статус");
            long defectAttach;
            while (true) {
                try {
                    defectAttach = Long.parseLong(scanner.nextLine());
                    if (!repository.containsKey(defectAttach)) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введите корреткный ID! Возможные варианты: ");
                    for (Long defectKey : repository.keySet()) {
                        System.out.println(defectKey);
                    }
                }
            }
            Status oldStatus = null;
            for (Defect defect : repository.values()) {
                if (defect.getID() == defectAttach) {
                    oldStatus = defect.getDefectStatus();
                    break;
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
            if (!Transition.SET_TRANSITION.contains(new Transition(oldStatus, defectStatus))) {
                System.out.println("Такой переход между статусами невалиден, статус изменен не будет\n");
            } else {
                for (Defect defect : repository.values()) {
                    if (defect.getID() == defectAttach) {
                        defect.setDefectStatus(defectStatus);
                        System.out.println("Статус дефекта успешно изменен!\n");
                        break;
                    }
                }
            }
        }
    }
    private static void showStatistics (Map<Long, Defect> repository) {
        if (repository.isEmpty()) {
            System.out.println("В системе нет ни одного дефекта\n");
        }
        else {
            IntSummaryStatistics dayCountStream = repository
                    .values()
                    .stream()
                    .mapToInt(Defect::getNumberOfDays)
                    .summaryStatistics();
            System.out.println
                    ("Максимальное количество дней на исправление: " + dayCountStream.getMax() + "\n" +
                     "Среднее количество дней на исправление: " + dayCountStream.getAverage() + "\n" +
                     "Минимальное количество дней на исправление: " + dayCountStream.getMin() + "\n");

            long countOPEN = repository
                    .values()
                    .stream()
                    .filter(defect -> defect.getDefectStatus() == Status.OPEN)
                    .count();

            long countASSIGNED = repository
                    .values()
                    .stream()
                    .filter(defect -> defect.getDefectStatus() == Status.ASSIGNED)
                    .count();

            long countFIXED = repository
                    .values()
                    .stream()
                    .filter(defect -> defect.getDefectStatus() == Status.FIXED)
                    .count();

            long countVERIFIED = repository
                    .values()
                    .stream()
                    .filter(defect -> defect.getDefectStatus() == Status.VERIFIED)
                    .count();

            long countCLOSED = repository
                    .values()
                    .stream()
                    .filter(defect -> defect.getDefectStatus() == Status.CLOSED)
                    .count();

            System.out.println
                    ("Статус   | Количество дефектов в этом статусе " + "\n" + "\n" +
                            "OPEN     | " + countOPEN + "\n" +
                            "ASSIGNED | " + countASSIGNED + "\n" +
                            "FIXED    | " + countFIXED + "\n" +
                            "VERIFIED | " + countVERIFIED + "\n" +
                            "CLOSED   | " + countCLOSED + "\n");
        }
    }
}