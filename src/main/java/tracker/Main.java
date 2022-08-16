package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Repository repository = new Repository();
            boolean work = true;
            while (work) {
                System.out.println("Вы находитесь в главном меню багтрекинговой системы. Выберите действие:" +
                        "\nДобавить новый дефект (введите команду add)" +
                        "\nВывести список дефектов (введите команду list)" +
                        "\nВернуться в главное меню (введите команду quit)" +
                        "\nИзменить статус дефекта (введите команду change)" +
                        "\nВывести статистику по дефектам (введите команду stats)");
                String command = scan.nextLine();
                switch (command) {
                    case "add":
                        add(repository,scan);
                        break;
                    case "list":
                        list(repository);
                        break;
                    case "change":
                        change(repository, scan);
                        break;
                    case "stats":
                        stats(repository);
                        break;
                    case "quit":
                        System.out.println("Завершение работы программы");
                        work = false;
                        break;
                    default:
                        System.out.println("Введена некорректная команда, возврат в главное меню");
                        break;
                }
            }
        }
    }

    public static void list(Repository repository) {
        if (repository.isEmpty()) {
            System.out.println("Дефектов не заведено!");
        } else {
            System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление, id, вложение, статус):");
            for (Defect defect : repository.getAll()){
                System.out.println(defect);
            }
        }
    }

public static void change(Repository repository,Scanner scan) {
    if (repository.isEmpty()) {
        System.out.println("Дефектов не заведено!");
    } else {
        //меняем статус
        System.out.println("Ввести id дефекта:");
        Long id = null;
        while (id == null) {
            try {
                id = Long.parseLong(scan.nextLine());
                if (repository.checkId(id)) {
                    break;
                } else {
                    id = null;
                    System.out.println("Такого дефекта нет, попробуйте ещё раз!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение, попробуйте ещё раз!");
            }
        }
        System.out.println("Ввести новый статус дефекта:" +
                "\n" + Arrays.toString(Status.values()));
        Status statusTo = null;
        while (statusTo == null) {
            try {
                statusTo = Status.valueOf(scan.nextLine());
                Defect defect = repository.getDefect(id);
                Status statusFrom = defect.getStatus();
                if (Transition.checkTransitions(statusFrom, statusTo)) {
                        defect.setStatus(statusTo);
                        System.out.println("Статус успешно изменён!");
                        System.out.println(" ");
                    }
                    else {
                        System.out.println("Нельзя перевести дефект в данный статус!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Введено некорректное значение, попробуйте ещё раз!");
                }
            }
        }
    }

    public static void add(Repository repository, Scanner scan) {
        //создаём переменную типа Defect и помещаем её в поле defects переменной repository
        System.out.println("Введите краткое описание дефекта:");
        String description = scan.nextLine();
        System.out.println("Следующий шаг: введите критичность дефекта" +
                "\n" + Arrays.toString(Severity.values()));
        Severity severity = null;
        while (severity == null) {
            try {
                severity = Severity.valueOf(scan.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Введено некорректное значение, попробуйте ещё раз!");
            }
        }
        System.out.println("Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
        int numberOfDays = 0;
        while (numberOfDays == 0){
            try {
                numberOfDays = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение, попробуйте ещё раз!");
            }
        }
        Attachment attachment = null;
        //цикл для вложения
        while (attachment == null) {
            System.out.println("Выберите тип вложения: " +
                    "\n" + "Введите команду comment для ввода комментария" +
                    "\n" + "Введите команду link для ссылки на другой дефект");
            String choiceOfAttachment = scan.nextLine();
            switch (choiceOfAttachment) {
                case "comment":
                    System.out.println("Введите коммент к дефекту");
                    String comment = scan.nextLine();
                    attachment = new CommentAttachment(comment);
                    break;
                case "link":
                    System.out.println("Введите ссылку на другой дефект");
                    long link = 0;
                    while (link == 0) {
                        try {
                            link = Long.parseLong(scan.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Введено некорректное значение, попробуйте ещё раз!");
                        }
                    }
                    attachment = new DefectAttachment(link);
                    break;
                default:
                    System.out.println("Вы ввели некорректное значение!" + "\n");
                    break;
            }
        }
        Defect defect = new Defect(description, severity, numberOfDays, attachment);
        System.out.println("Вы ввели следующий дефект:");
        System.out.println(defect);
        repository.add(defect);
    }
    public static void stats (Repository repository) {
        if (repository.isEmpty()) {
            System.out.println("Дефектов не заведено!");
        } else {
            ArrayList <Integer> numberOfDays = new ArrayList<>();
            for (Defect defect: repository.getAll()) {
                numberOfDays.add(defect.getNumberOfDays());
            }
            IntSummaryStatistics intSummaryStatistics = numberOfDays.stream()
                    .mapToInt(Integer::intValue)
                    .summaryStatistics();
            System.out.println("Максимальное количество дней на исправление: " +intSummaryStatistics.getMax());
            System.out.println("Среднее количество дней на исправление: " +intSummaryStatistics.getAverage());
            System.out.println("Минимальное количество дней на исправление: " +intSummaryStatistics.getMin()  + "\n");
//            ArrayList <Status> stat = new ArrayList<>();
//            for (Defect defForStat: repository.getAll()) {
            Map<Status, Long> statusOfDefects = repository.getAll().stream()
                    .collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));
            System.out.println("Статус, количество дефектов в этом статусе:");
            System.out.println(statusOfDefects + "\n");
        }
    }
}
