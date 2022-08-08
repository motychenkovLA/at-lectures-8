package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            final int MAX_DEFECTS = 10;
            Repository repository = new Repository(MAX_DEFECTS);
            boolean work = true;
            while (work) {
                System.out.println("Вы находитесь в главном меню багтрекинговой системы. Выберите действие:" +
                        "\nДобавить новый дефект (введите команду add)" +
                        "\nВывести список дефектов (введите команду list)" +
                        "\nВернуться в главное меню (введите команду quit)" +
                        "\nИзменить статус дефекта (введите команду change)");
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
        if (repository.getCount() == 0) {
            System.out.println("Дефектов не заведено!");
        } else {
            System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление, id, вложение, статус):");
            Defect[] defectsForArray = repository.getAll();
            for (Defect defForOut : defectsForArray) {
                System.out.println(defForOut.toString());
            }
        }
    }

    public static void change(Repository repository,Scanner scan) {
        if (repository.getCount() == 0) {
            System.out.println("Дефектов не заведено!");
        } else {
            //меняем статус
            System.out.println("Ввести id дефекта:");
            boolean flag = true;
            long id = 0;
            while (flag) {
                try {
                    id = Long.parseLong(scan.nextLine());
                    flag = false;
                } catch (NumberFormatException e) {
                    System.out.println("Введено некорректное значение, попробуйте ещё раз!");
                }
            }
            Defect[] arrayChangeStatus = repository.getAll();
            for (Defect defForChange : arrayChangeStatus) {
                if (id == defForChange.getId()) {
                    System.out.println("Ввести новый статус дефекта:" +
                            "\n" + Arrays.toString(Status.values()));
                    Status status = null;
                    while (status == null) {
                        try {
                            status = Status.valueOf(scan.nextLine());
                            defForChange.setStatus(status);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Введено некорректное значение, попробуйте ещё раз!");
                        }
                    }
                    System.out.println("Статус успешно изменён!");
                    System.out.println(" ");
                } else {
                    System.out.println("Такого дефекта нет! Возврат в главное меню");
                }
                break;
            }
        }
    }

    public static void add(Repository repository, Scanner scan) {
        if (repository.isNotFull()) {
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
        } else {
            System.out.println("Закончилось место для заведения дефектов!");
        }
    }
}
