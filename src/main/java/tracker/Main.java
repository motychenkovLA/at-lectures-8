package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int COUNT_BUG = 10;
        Repository repository = new Repository(COUNT_BUG);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true; // todo 3 - объявлена слишком далеко от использования, дублирует более простое условие
        boolean run = true;
        while (run) {
            System.out.println("Главное меню:  " +
                    "\nДобавить новый дефевкт - введите \"add\" " +
                    "\nВывести список дефектов - введите \"list\" " +
                    "\nВыйти из программы - введите \"quit\"");
            switch (scanner.nextLine()) {
                case "add":
                    if (repository.full()) {
                        System.out.println("Вы ввели максимальное колличество дефектов");
                        System.out.println();
                        break;
                    }
                    if (!loop) {
                        loop = true;
                    }
                    System.out.println("Введите резюме дефекта");
                    String resumes = scanner.nextLine();
                    System.out.println("Введите критичность дефекта из списка : High, Low, Medium");
                    String priorities = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    Attachment attachment = null;
                    while (loop) {
                        System.out.println("Выберите тип вложения" +
                                "\nДля добавления комментарий - введите \"comments\"" +
                                "\nДля добавления ссылки на другой дефект - введите \"link\"");
                        switch (scanner.nextLine()) {
                            case "comments":
                                System.out.println("Введите комменатарий:");
                                String comment = scanner.nextLine();
                                attachment = new CommentAttachment(comment);
                                loop = false;
                                break;
                            case "link":
                                System.out.println("Введите id дефекта:");
                                int link = scanner.nextInt();
                                scanner.nextLine();
                                attachment = new DefectAttachment(link);
                                loop = false;
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
                        System.out.println(def.getField());
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
