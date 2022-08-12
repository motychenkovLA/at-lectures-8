package tracker;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_SIZE_DEFECT = 5;
        Repository repository = new Repository(ARRAY_SIZE_DEFECT);

        boolean isRun = true;

        try (Scanner scanner = new Scanner(System.in);) {
            //цикл для выбора действия пользователя
            while (isRun) {
                String userDo = doIn(scanner);
                switch (userDo) {
                    case "add":
                        if (repository.getAmountDefects() < ARRAY_SIZE_DEFECT) {
                            String resume = resumeDefectIn(scanner);
                            Criticality criticality;
                            Attachment attachment;
                            criticality = criticalityDefectIn(scanner);
                            int amountDay = amountDayIn(scanner);
                            attachment = typeAttachmentIn(scanner, repository);
                            //объявляем экзмепляр класса Defect
                            Defect defect = new Defect(resume, criticality, amountDay, attachment);
                            //выводим информацию о дефекте
                            System.out.println("Информация о дефекте: ");
                            System.out.println("Id " + defect.getId() + " | " + "Резюме: " + resume + " | " + "Серьезность " + criticality +
                                    " | " + "Количество дней на исправление " + amountDay + " | " + " Комментарий или id дефекта: " +
                                    attachment + " | " + "Статус:" + defect.getStatus());
                            //заносим дефект в массив
                            repository.add(defect);
                        } else {
                            System.out.println("Закончилось место, невозможно ввести новый дефект");
                        }
                        break;
                    case "list":
                        System.out.println(repository.getAllDefectsInfo());
                        //выход из цикла
                        break;
                    case "quit":
                        isRun = false;
                        break;
                    case "change":
                        Defect concreteDefect = getDefectById(scanner, repository);
                        concreteDefect.setStatus((statusDefectIn(scanner)));
                        break;
                    default:
                        System.out.println("Введите корректное значение");
                        break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Вы ввели неправильное значение. Пожалуйста, начните сначала.");
        }
    }

    public static String doIn(Scanner scanner) {
        System.out.println("Выберите действие: добавить новый дефект (\"add\"), " +
                "вывести список (\"list\"), " + "изменить статус (\"change\"), " + "выйти из программы (\"quit\") - главное меню");
        String userDo = scanner.nextLine();
        return userDo;
    }

    public static String resumeDefectIn(Scanner scanner) {
        System.out.println("Введите резюме дефекта");
        String resume = scanner.nextLine();
        return resume;
    }

    public static Criticality criticalityDefectIn(Scanner scanner) {
        Criticality criticality = null;
        System.out.println("Введите критичность дефекта: " +
                Arrays.toString(Criticality.values()));
        do {
            try {
                String criticalityIn = scanner.nextLine();
                criticality = Criticality.valueOf(criticalityIn);
            } catch (IllegalArgumentException e) {
                System.out.println("Введите критичность корректно");
            }
        } while (criticality == null);
        return criticality;
    }

    public static StatusDefect statusDefectIn(Scanner scanner) {
        StatusDefect statusDefect = null;
        scanner.nextLine();
        System.out.println("Введите статус дефекта: " +
                Arrays.toString(StatusDefect.values()));
        do {
            try {
                String newStatusDefect = scanner.nextLine();
                statusDefect = StatusDefect.valueOf(newStatusDefect);
            } catch (IllegalArgumentException e) {
                System.out.println("Введите статус корректно");
            }
        } while (statusDefect == null);
        return statusDefect;
    }

    public static int amountDayIn(Scanner scanner) {
        int amountDays = -1;
        System.out.println("Введите ожидамое количество дней на исправление дефекта");
        while (amountDays < 0) {
            try {
                amountDays = scanner.nextInt();
                if (amountDays < 0) {
                    System.out.println("Введите значение больше нуля");
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Введите корректное ожидамое количество дней на исправление дефекта ещё раз");
            }
            scanner.nextLine();
        }
        return amountDays;
    }

    public static Defect getDefectById(Scanner scanner, Repository repository) {

        long defectId = 0;
        System.out.println("Введите id дефекта: ");
        Defect defect = null;
        while (defect == null) {
            try {
                defect = repository.getDefectById(scanner.nextLong());
                if (defect == null) {
                    System.out.println("Дефекта с таким id не существует или введен неправильный id. Введите корректный id");
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Введите корректный id");
                scanner.nextLine();
            }

        }
        return defect;
    }

    public static Attachment typeAttachmentIn(Scanner scanner, Repository repository) {
        Attachment attachment = null;
        System.out.println("Выберите тип вложения: \"Комментарий\" (comment) или " +
                "\"Ссылка на другой дефект\" (link)");
        while (attachment == null) {
            String typeAttachment = scanner.nextLine();

            switch (typeAttachment){
                case "comment":
                    System.out.println("Введите комментарий:");
                    attachment = new CommentAttachment(scanner.nextLine());
                    break;
                case "link":
                    while (attachment == null) {
                        try{
                            long id = getDefectById(scanner, repository).getId();
                            attachment = new DefectAttachment(id);
                        }catch (IllegalArgumentException | InputMismatchException e){
                            System.out.println("Введите id корректно");
                        }
                        scanner.nextLine();
                    }
                    break;
                default:
                    System.out.println("Введите корректное значение вложения");
                    break;
            }
        }
        return attachment;
    }

    public void printCriticality() {
        for (Criticality criticalityDefect : Criticality.values()) {
            System.out.println(criticalityDefect);
        }
    }


}

