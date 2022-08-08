package tracker;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // todo 3 - 10 же вместо 3; + это константа
        Repository repository = new Repository(3);
        //переменная отвечающая за работу цикла
        // todo 1 - вот эти 3 переменные очень сильно оторваны от их использования
        Criticality criticality;
        int amountDays; // todo 1 - а эта даже не используется
        Attachment attachment;
        boolean isRun = true;

        try(Scanner scanner = new Scanner(System.in);) {
            //цикл для выбора действия пользователя
            // todo 1 - что-то с отступами
        while (isRun) {

                String userDo = doIn(scanner);
                //условный оператор с условием добавления дефекта
            // todo * - даже компилятор просит тут switch
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
                    // todo * - не здорово сначала просить ввести гору полей а только потом сказать что у нас места нету
                    repository.add(defect);
                    //если пользователь хочет вывести дефекты на экран
                } else if (userDo.equals("list")) {
                    //цикл для вывода массива дефектов
                    // todo * -
                    //  1) почему не for each
                    //  2) очень напрягает то что на каждой итерации N раз дергается getAll() который между прочем копирует вообще весь массив
                    //  3) зачем тут форматировать дефект в текст если есть toString()
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
                    // todo 3 - вот тут можно упасть если пользователь не Long введет
                    long idForChange = scanner.nextLong();
                    scanner.nextLine();
                    for (Defect defectFromArray : repository.getAll()) {
                        if (idForChange == defectFromArray.getId()) {
                            System.out.println("Введите статус дефекта: " + Arrays.toString(StatusDefect.values()));
                            String newStatusDefect = scanner.nextLine();
                            // todo 3 - вот тут можно упасть если пользователь введет не валидный статус
                            defectFromArray.setStatus(StatusDefect.valueOf(newStatusDefect));
                            break;
                        } else {
                            // todo 3 - выведет сообщение для каждого дефекта у которого id не совпадет с веденным
                            System.out.println("Введите корректный статус");
                        }
                    }
                }
                //если пользователь ввел некорреткное значение
                else {
                    System.out.println("Введите корректное значение");
                }
            }

            } // todo 1 - catch не переносят
        catch (IllegalArgumentException e){
            System.out.println("Вы ввели неправильное значение. Пожалуйста, начните сначала.");
        }
    }

    public static String doIn(Scanner scanner) {
        System.out.println("Выберите действие: добавить новый дефект (\"add\"), " +
                "вывести список (\"list\"), " + "изменить статус (\"change\"), " + "выйти из программы (\"quit\") - главное меню");
        //объявляем и вводим переменную действия пользователя
        // todo 1 - warning
        String userDo = scanner.nextLine();
        return userDo;
    }

    public static String resumeDefectIn(Scanner scanner) {
        System.out.println("Введите резюме дефекта");
        // todo 1 - warning
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
            if (criticality != null) {break;} // todo 3 - вот это вот условие выхода из цикла,
                                              //  у цикла есть специальное место чтоб вписать условие выхода
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
                amountDays = -1; // todo 3 - почему не присвоить заранее?
            }
            scanner.nextLine();
            if (amountDays > 0) {break;} // todo 3 - опять-таки это условие выхода из цикла
            else {
                // todo 3 - почему не выводить сразу в catch блоке?
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
                // todo (см ниже) - attachment = new ...; isRun = false
                attachment = new CommentAttachment(comment);
                isRun = false;
            } else if (typeAttachment.equals("link")) {
                System.out.println("Введите id дефекта:");
                int idDefect = scanner.nextInt();
                scanner.nextLine();
                // todo 3 - attachment = new ...; isRun = false
                //  isRun всегда true когда attachment null;
                //  isRun всегда false когда attachment не null;
                //  дублирование логики
                attachment = new DefectAttachment(idDefect);
                isRun = false;
            } else {
                System.out.println("Введите корректное значение вложения");
            }
        }
        return attachment;
    }

    // todo 0 - вообще никто не запрещает делать вот так
    //   while (true) {
    //       try {
    //           Input input = readSomething();
    //           Result result = transform(input);
    //           return result;
    //       } catch (...) {
    //           sout("error");
    //       }
    //   }
}

