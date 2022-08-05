package tracker;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository(3);
        //переменная отвечающая за работу цикла
        Criticality criticality;
        int amountDays;
        Attachment attachment;
        boolean isRun = true;

        try(Scanner scanner = new Scanner(System.in);) {
            //цикл для выбора действия пользователя
        while (isRun) {

                String userDo = doIn(scanner);
                //условный оператор с условием добавления дефекта
                if (userDo.equals("add")) {
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
                } else if (userDo.equals("list")) {
                    //цикл для вывода массива дефектов
                    for (int i = 0; i < repository.getAmountDefects(); i++) {
                        System.out.println(repository.getAll()[i].getId());
                        System.out.println(repository.getAll()[i].getAmountForCorrect());
                        System.out.println(repository.getAll()[i].getCriticality());
                        System.out.println(repository.getAll()[i].getResume());
                        System.out.println(repository.getAll()[i].getAttachment().toString());
                        System.out.println(repository.getAll()[i].getStatus());
                        System.out.println();
                    }
                    //выход из цикла
                } else if (userDo.equals("quit")) {
                    isRun = false;
                } else if (userDo.equals("change")) {
                    System.out.println("Введите id дефекта: ");
                    long idForChange = scanner.nextLong();
                    scanner.nextLine();
                    for (Defect defectFromArray : repository.getAll()) {
                        if (idForChange == defectFromArray.getId()) {
                            System.out.println("Введите статус дефекта: " + Arrays.toString(StatusDefect.values()));
                            String newStatusDefect = scanner.nextLine();
                            defectFromArray.setStatus(StatusDefect.valueOf(newStatusDefect));
                            break;
                        } else {
                            System.out.println("Введите корректный статус");
                        }
                    }
                }
                //если пользователь ввел некорреткное значение
                else {
                    System.out.println("Введите корректное значение");
                }
            }

            }
        catch (IllegalArgumentException e){
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
        while (true) {
            try {
                String criticalityIn = scanner.nextLine();
                criticality = Criticality.valueOf(criticalityIn);
            }catch (IllegalArgumentException e){
                System.out.println("Введите критичность корректно");
            }
            if (criticality != null) {break;}
        }
        return criticality;
    }

    public static int amountDayIn(Scanner scanner) {
        int amountDays;
        System.out.println("Введите ожидамое количество дней на исправление дефекта");
        while (true) {
            try {
                amountDays = scanner.nextInt();
            }catch (IllegalArgumentException | InputMismatchException e){
                amountDays = -1;
            }
            scanner.nextLine();
            if (amountDays > 0) {break;}
            else {
                System.out.println("Введите корректное ожидамое количество дней на исправление дефекта ещё раз");
            }
        }
        return amountDays;
    }

    public static Attachment typeAttachmentIn(Scanner scanner) {
        Attachment attachment = null;
        System.out.println("Выберите тип вложения: \"Комментарий\" (comment) или " +
                "\"Ссылка на другой дефект\" (link)");
        boolean isRun = true;
        while (isRun) {
            String typeAttachment = scanner.nextLine();
            if (typeAttachment.equals("comment")) {
                System.out.println("Введите комментарий:");
                String comment = scanner.nextLine();
                attachment = new CommentAttachment(comment);
                isRun = false;
            } else if (typeAttachment.equals("link")) {
                System.out.println("Введите id дефекта:");
                int idDefect = scanner.nextInt();
                scanner.nextLine();
                attachment = new DefectAttachment(idDefect);
                isRun = false;
            } else {
                System.out.println("Введите корректное значение вложения");
            }
        }
        return attachment;
    }


}

