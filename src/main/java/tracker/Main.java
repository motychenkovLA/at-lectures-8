package tracker;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int arraySizeDefect = 10;
        Repository repository = new Repository(arraySizeDefect);
        //переменная отвечающая за работу цикла
        Criticality criticality;
        Attachment attachment;
        boolean isRun = true;

        try (Scanner scanner = new Scanner(System.in);) {
            //цикл для выбора действия пользователя
            while (isRun) {
                String userDo = doIn(scanner);
                //условный оператор с условием добавления дефекта
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
                            //если пользователь хочет вывести дефекты на экран
                        } else {
                            System.out.println("Закончилось место, невозможно ввести новый дефект");
                        }
                        break;
                    case "list":
                        for (Defect defect : repository.getArrayDefects()) {
                            System.out.println(defect);
                        }
                        //выход из цикла
                        break;
                    case "quit":
                        isRun = false;
                        break;
                    case "change":
                        long idForChange;
                        for (Defect defectFromArray : repository.getAll()) {
                            idForChange = idForChangeIn(scanner, defectFromArray);
                            if (idForChange == defectFromArray.getId()) {
                                defectFromArray.setStatus(StatusDefect.valueOf(statusDefectIn(scanner)));
                                break;
                            }
                        }
                        break;
                    //если пользователь ввел некорреткное значение
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
        //объявляем и вводим переменную действия пользователя
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

    public static String statusDefectIn(Scanner scanner) {
        StatusDefect statusDefect = null;
        String newStatusDefect = "NEW";
        System.out.println("Введите статус дефекта: " + Arrays.toString(StatusDefect.values()));
        do {
            try {
                newStatusDefect = scanner.nextLine();
                statusDefect = StatusDefect.valueOf(newStatusDefect);
            } catch (IllegalArgumentException e) {
                System.out.println("Введите статус корректно");
            }
        } while (statusDefect == null);
        return newStatusDefect;
    }

    public static int amountDayIn(Scanner scanner) {
        int amountDays = -1;
        System.out.println("Введите ожидамое количество дней на исправление дефекта");
        while (amountDays < 0) {
            try {
                amountDays = scanner.nextInt();
                if (amountDays < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Введите корректное ожидамое количество дней на исправление дефекта ещё раз");
            }
            scanner.nextLine();
        }
        return amountDays;
    }

    public static long idForChangeIn(Scanner scanner, Defect defectFromArray) {
        long idForChange = -1L;
        System.out.println("Введите id дефекта: ");
        while (idForChange != defectFromArray.getId()) {
            try {
                idForChange = scanner.nextLong();
                if (idForChange != defectFromArray.getId()) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Дефекта с таким id не существует, введите корректный id");
            }
            scanner.nextLine();
        }
        return idForChange;
    }

    public static Attachment typeAttachmentIn(Scanner scanner) {
        Attachment attachment = null;
        System.out.println("Выберите тип вложения: \"Комментарий\" (comment) или " +
                "\"Ссылка на другой дефект\" (link)");
//        boolean isRun = true;
        while (attachment == null) {
            String typeAttachment = scanner.nextLine();
            if (typeAttachment.equals("comment")) {
                System.out.println("Введите комментарий:");
                String comment = scanner.nextLine();
                attachment = new CommentAttachment(comment);
//                isRun = false;
            } else if (typeAttachment.equals("link")) {
                System.out.println("Введите id дефекта:");
                int idDefect = scanner.nextInt();
                scanner.nextLine();
                attachment = new DefectAttachment(idDefect);
//                isRun = false;
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

