package tracker;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        boolean run = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (run) {
                System.out.println("Главное меню:" +
                        "\nДобавить новый дефевкт - введите \"add\" " +
                        "\nВывести список дефектов - введите \"list\" " +
                        "\nИзменить статус дефекта - введите \"change\"" +
                        "\nВывести статистику - введите \"stats\"" +
                        "\nВыйти из программы - введите \"quit\"");
                switch (scanner.nextLine()) {
                    case "add":
                        add(scanner, repository);
                        break;
                    case "list":
                        for (Defect defect : repository.getAll()) {
                            System.out.println(defect);
                        }
                        break;
                    case "change":
                        change(scanner, repository);
                        break;
                    case "stats":
                        stats(repository);
                        break;
                    case "quit":
                        run = false;
                        break;
                    default:
                        break;
                }
            }
        }

    }

    public static void add(Scanner scanner, Repository repository) {
        System.out.println("Введите резюме дефекта");
        String resumes = scanner.nextLine();
        System.out.println("Введите критичность дефекта из списка : ");
        Criticality[] valuesCriticality = Criticality.values();
        for (Criticality value : valuesCriticality) {
            System.out.println(value);
        }
        Criticality priorities = null;
        while (priorities == null) {
            try {
                priorities = Criticality.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Вы ввели не верное значение");
                System.out.println("Введите критичность дефекта из списка : ");
                for (Criticality value : valuesCriticality) {
                    System.out.println(value);
                }
            }
        }
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int days = 0;
        while (days <= 0) {
            try {
                days = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите целое положительное число");
            }
        }
        Attachment attachment = attachment(scanner);
        Defect defect = new Defect(resumes, priorities, days, attachment);
        repository.add(defect);
    }

    private static Attachment attachment(Scanner scanner) {
        Attachment attachment = null;
        while (attachment == null) {
            System.out.println("Выберите тип вложения:" +
                    "\nДля добавления комментарий - введите \"comments\"" +
                    "\nДля добавления ссылки на другой дефект - введите \"link\"");
            switch (scanner.nextLine()) {
                case "comments":
                    System.out.println("Введите комменатарий:");
                    String comment = scanner.nextLine();
                    attachment = new CommentAttachment(comment);
                    break;
                case "link":
                    System.out.println("Введите id дефекта:");
                    long link = 0;
                    while (link <= 0) {
                        try {
                            link = Long.parseLong(scanner.nextLine());
                            attachment = new DefectAttachment(link);
                        } catch (NumberFormatException e) {
                            System.out.println("Введите целое положительное число");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return attachment;
    }

    public static void change(Scanner scanner, Repository repository) {
        System.out.println("Введите id дефекта:");
        boolean checkId = true;
        while (checkId) {
            try {
                long id = Long.parseLong(scanner.nextLine());
                Defect def = repository.getId(id);
                if (def == null) {
                    System.out.println("Введенный id отсутствует в списке дефектов." +
                            "\nВведите id дефекта:");
                    continue;
                } else checkId = false;
                System.out.println("Измените статус дефекта на один из вариантов: ");
                Status[] valuesStatus = Status.values();
                for (Status value : valuesStatus) {
                    System.out.println(value);
                }
                Status to;
                boolean checkStatus = true;
                while (checkStatus) {

                    try {
                        to = Status.valueOf(scanner.nextLine());
                        if (Transition.checkTransition(def.getStatus(), to)) {
                            def.setStatus(to);
                            checkStatus = false;
                        } else {
                            System.out.println("Переход в этот статус невозможен");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Измените статус дефекта на один из вариантов: ");
                        valuesStatus = Status.values();
                        for (Status value : valuesStatus) {
                            System.out.println(value);
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенный id отсутствует в списке дефектов." +
                        "\nВведите id дефекта:");
            }

        }

    }

    public static void stats(Repository repository) {
        Map<Status, Long> stat = repository.getAll().stream()
                .collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));

        stat.forEach((Status, Long) -> System.out.println("Количество дефектов в статусе " + Status.getName() +
                " равно " + Long));

        IntSummaryStatistics intSummaryStatistics = repository.getAll().stream()
                .collect(Collectors.summarizingInt(Defect::getDays));
        System.out.println("Максимальное количество дней на исправление: " + intSummaryStatistics.getMax() + "\n" +
                "Минимальное количество дней на исправление: " + intSummaryStatistics.getMin() + "\n" +
                "Среднее количество дней на исправление: " + intSummaryStatistics.getAverage() + "\n");
    }

}
