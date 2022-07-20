package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository(3);
        //переменная отвечающая за работу цикла
        boolean isRun = true;
        //цикл для выбора действия пользователя
        while (isRun) {
            System.out.println("Выберите действие: добавить новый дефект (\"add\"), " +
                    "вывести список (\"list\"), " + "изменить статус (\"change\"), " + "выйти из программы (\"quit\") - главное меню");
            //объявляем и вводим переменную действия пользователя
            String userDo = scanner.nextLine();
            //условный оператор с условием добавления дефекта
            if (userDo.equals("add")) {
                //условный оператор, позволяющий вводить нужное количество дефектов
                System.out.println("Введите резюме дефекта");
                String resume = scanner.nextLine();
                System.out.println("Введите критичность дефекта: " +
                        Criticality.valueOf("HIGHEST") + ", " + Criticality.valueOf("HIGH") + ", " +
                        Criticality.valueOf("MIDDLE") + ", " + Criticality.valueOf("LOW"));
                String criticality = scanner.nextLine();
                System.out.println("Введите ожидамое количество дней на исправление дефекта");
                int amountDays = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Выберите тип вложения: \"Комментарий\" (comment) или " +
                        "\"Ссылка на другой дефект\" (link)");
                String typeAttachment = scanner.nextLine();
                Attachment attachment = null;
                if (typeAttachment.equals("comment")) {
                        System.out.println("Введите комментарий:");
                        String comment = scanner.nextLine();
                        attachment = new CommentAttachment(comment);
                } else if (typeAttachment.equals("link")) {
                        System.out.println("Введите id дефекта:");
                        int idDefect = scanner.nextInt();
                        scanner.nextLine();
                        attachment = new DefectAttachment(idDefect);
                } else {
                        System.out.println("Введите корреткное значение вложения");
                }
                //объявляем экзмепляр класса Defect
                Defect defect = new Defect(resume, criticality, amountDays, attachment);
                //выводим информацию о дефекте
                System.out.println("Информация о дефекте: ");
                System.out.println("Id " + defect.getId() + " | " + "Резюме: " + resume + " | " + "Серьезность " + criticality +
                        " | " + "Количество дней на исправление " + amountDays + " | " + " Комментарий или id дефекта: " +
                        attachment.toString() + " | " + "Статус:" + defect.getStatus());
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
                long idForChange = scanner.nextInt();
                scanner.nextLine();
                for (Defect defectFromArray:repository.getAll()) {
                    if (idForChange == defectFromArray.getId()) {
                        System.out.println("Введите статус дефекта: " + StatusDefect.valueOf("OPEN") + ", "
                                + StatusDefect.valueOf("ANALYSIS") + ", " + StatusDefect.valueOf("CORRECTION") + ", "
                                + StatusDefect.valueOf("TESTING") + ", " + StatusDefect.valueOf("CLOSE"));
                        String newStatusDefect = scanner.nextLine();
                        if (StatusDefect.OPEN.toString().equals(newStatusDefect)) {
                            defectFromArray.setStatus(StatusDefect.OPEN);
                        } else if (StatusDefect.ANALYSIS.toString().equals(newStatusDefect)) {
                            defectFromArray.setStatus(StatusDefect.ANALYSIS);
                        } else if (StatusDefect.CORRECTION.toString().equals(newStatusDefect)) {
                            defectFromArray.setStatus(StatusDefect.CORRECTION);
                        } else if (StatusDefect.TESTING.toString().equals(newStatusDefect)) {
                            defectFromArray.setStatus(StatusDefect.TESTING);
                        } else if (StatusDefect.CLOSE.toString().equals(newStatusDefect)) {
                            defectFromArray.setStatus(StatusDefect.CLOSE);
                        } else {
                            System.out.println("Введите корректное значение");
                        }
                    }
                }
            }
            //если пользователь ввел некорреткное значение
            else {
                System.out.println("Введите корректное значение");
            }
        }
    }
}

