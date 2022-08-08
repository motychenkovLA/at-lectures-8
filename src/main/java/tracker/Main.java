package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int COUNT_BUG = 10;
        Repository repository = new Repository(COUNT_BUG);
        boolean run = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (run) {
                System.out.println("Главное меню:" +
                        "\nДобавить новый дефевкт - введите \"add\" " +
                        "\nВывести список дефектов - введите \"list\" " +
                        "\nИзменить статус дефекта - введите \"change\"" +
                        "\nВыйти из программы - введите \"quit\"");
                switch (scanner.nextLine()) {
                    case "add":
                        if (repository.full()) {
                            System.out.println("Вы ввели максимальное колличество дефектов");
                            System.out.println();
                            break;
                        }
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
                                    int link = 0;
                                    while (link <= 0) {
                                        try {
                                            link = Integer.parseInt(scanner.nextLine());
                                        } catch (NumberFormatException e) {
                                            System.out.println("Введите целое положительное число");
                                        }
                                    }
                                    attachment = new DefectAttachment(link);
                                    break;
                                default:
                                    break;
                            }
                        }
                        Defect defect = new Defect(resumes, priorities, days, attachment);
                        repository.add(defect);
                        break;
                    case "list":
                        for (Defect def : repository.getAll()) {
                            System.out.println(def.toString());
                        }
                        break;
                    case "change":
                        System.out.println("Введите id дефекта:");
                        long id = 0;
                        while (id <= 0) {
                            try {
                                id = Long.parseLong(scanner.nextLine());
                                if (repository.getId(id) == null) {
                                    System.out.println("Введенный id отсутствует в списке дефектов."+
                                            "\nВведите id дефекта:");
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Введенный id отсутствует в списке дефектов." +
                                        "\nВведите id дефекта:");
                            }
                        }

                        System.out.println("Измените статус дефекта на один из вариантов: ");
                        Status[] valuesStatus = Status.values();
                        for (Status value : valuesStatus) {
                            System.out.println(value);
                        }
                        Status status = null;
                        while (status == null) {
                            try {
                                status = Status.valueOf(scanner.nextLine());
                                for (Defect repo : repository.getAll()) {
                                    if (id == repo.getId()) {
                                        repo.setStatus(status);
                                    }
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Измените статус дефекта на один из вариантов: ");
                                valuesStatus = Status.values();
                                for (Status value : valuesStatus) {
                                    System.out.println(value);
                                }
                            }
                        }
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
}
