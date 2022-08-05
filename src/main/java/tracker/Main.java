package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository(3);
        //переменная отвечающая за работу цикла
        boolean isRun = true;
        //цикл для выбора действия пользователя
        try(Scanner scanner = new Scanner(System.in);) {
            MenuForInn menuForInn = new MenuForInn();
        while (isRun) {

                String userDo = menuForInn.doIn();
                //условный оператор с условием добавления дефекта
                if (userDo.equals("add")) {
                    String resume = menuForInn.resumeDefectIn();
                    Criticality criticality = menuForInn.criticalityDefectIn();
                    int amountDay = menuForInn.amountDayIn();
                    Attachment attachment = menuForInn.typeAttachmentIn();
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
}

