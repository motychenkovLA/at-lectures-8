package tracker;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int arraySizeDefect = 5; // todo 1 - вообще это константа, а код стайл как от обычной переменной
        Repository repository = new Repository(arraySizeDefect);
//        repository.add(new Defect("res1", Criticality.LOW, 12, new CommentAttachment("comm1"))); // todo 0 - не надо оставлять комменты
//        repository.add(new Defect("res2", Criticality.HIGH, 1, new CommentAttachment("comm2")));
//        repository.add(new Defect("res3", Criticality.HIGHEST, 10, new CommentAttachment("comm3")));
        Criticality criticality; // todo 1 - объявлены далеко от использования
        Attachment attachment;
        boolean isRun = true;

        try (Scanner scanner = new Scanner(System.in);) {
            //цикл для выбора действия пользователя
            while (isRun) {
                String userDo = doIn(scanner);
                switch (userDo) {
                    case "add":
                        if (repository.getAmountDefects() < arraySizeDefect) {
                            String resume = resumeDefectIn(scanner);
                            criticality = criticalityDefectIn(scanner);
                            int amountDay = amountDayIn(scanner);
                            attachment = typeAttachmentIn(scanner);
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
                        // todo 5 - зачем тут выводятся нуллы?
                        for (Defect defect : repository.getArrayDefects()) {
                            System.out.println(defect);
                        }
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
                    // todo 1 - ну вот так не очень хорошо делать (выкидывать и тут же ловить),
                    //  получается что try-catch просто используется вместо if-else.
                    //  конкретно здесь можно например выводить другое сообщение об ошибке вместо выброса исключения
                    throw new IllegalArgumentException();
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
        while (true) {
            try {
                defectId = scanner.nextLong();
                // todo 1 - не особо нужный if
                if (defectId > 999999) {
                    // todo 3 - в идеале поиск по ид должен производить сам репо
                    for (Defect d: repository.getAll()){
                        if(d.getId() == defectId){
                            return d;
                            // todo 3 - в случае выполнения условия возвращаемся из метода,
                            //  весь остальной код здесь тогда не выполняется,
                            //  в том числе и scanner.nextLine()
                        }
                    }
                    // todo 3 - аналогично комменту выше по поводу выкидывания и мгновенного отлавливания исключений.
                    //   эта строчка достижима только если введено валидное число (иначе ушли бы в catch)
                    //   + не найден дефект (иначе ушли бы в return), этого достаточно чтобы вывести сообщение об ошибке
                    throw new InputMismatchException();
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Дефекта с таким id не существует или введен неправильный id. Введите корректный id");
            }
            scanner.nextLine();
        }
    }

    public static Attachment typeAttachmentIn(Scanner scanner) {
        Attachment attachment = null;
        System.out.println("Выберите тип вложения: \"Комментарий\" (comment) или " +
                "\"Ссылка на другой дефект\" (link)");
        while (attachment == null) {
            String typeAttachment = scanner.nextLine();
            if (typeAttachment.equals("comment")) {
                System.out.println("Введите комментарий:");
                String comment = scanner.nextLine();
                attachment = new CommentAttachment(comment);
            } else if (typeAttachment.equals("link")) {
                System.out.println("Введите id дефекта:");
                // todo 0 - проглядели в прошлом дз, тут можно упасть если не число ввелось
                int idDefect = scanner.nextInt();
                scanner.nextLine();
                attachment = new DefectAttachment(idDefect);
            } else {
                System.out.println("Введите корректное значение вложения");
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

