package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository(3);
        boolean isRun = true;
        while (isRun) {
            System.out.println("Укажите операцию: добавление нового дефекта (\"add\"), " +
                    "вывод списка (\"list\"), " + "измение статуса (\"change\"), " + "выход из программы (\"quit\") - главное меню");
            String userDo = scanner.nextLine();
            if (userDo.equals("add")) {
                System.out.println("Ввод резюме дефекта");
                String resume = scanner.nextLine();
                System.out.println("Ввод критичности дефекта: " +
                        Arrays.toString(Criticality.values()));
                String criticalityIn = scanner.nextLine();
                Criticality criticality = Criticality.valueOf(criticalityIn);
                System.out.println("Ввод ожидамого количества дней на исправление дефекта");
                int amountDays = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Укажите вид вложения: \"Коммент\" (comment) или " +
                        "\"Ссылка на дефект\" (link)");
                String typeAttachment = scanner.nextLine();
                Attachment attachment = null;
                if (typeAttachment.equals("comment")) {
                    System.out.println("Ввод комментария:");
                    String comment = scanner.nextLine();
                    attachment = new CommentAttachment(comment);
                } else if (typeAttachment.equals("link")) {
                    System.out.println("Ввод id дефекта:");
                    int idDefect = scanner.nextInt();
                    scanner.nextLine();
                    attachment = new DefectAttachment(idDefect);
                } else {
                    System.out.println("Ввод корреткного значения вложения");
                }
                Defect defect = new Defect(resume, criticality, amountDays, attachment);
                System.out.println("Информация о дефекте: ");
                System.out.println("Id " + defect.getId() + " | " + "Резюме: " + resume + " | " + "Серьезность " + criticality +
                        " | " + "Количество дней на исправление " + amountDays + " | " + " Коммент или id дефекта: " +
                        attachment.toString() + " | " + "Статус:" + defect.getStatus());
                repository.add(defect);
            } else if (userDo.equals("list")) {
                for (int i = 0; i < repository.getAmountDefects(); i++) {
                    System.out.println(repository.getAll()[i].getId());
                    System.out.println(repository.getAll()[i].getAmountForCorrect());
                    System.out.println(repository.getAll()[i].getCriticality());
                    System.out.println(repository.getAll()[i].getResume());
                    System.out.println(repository.getAll()[i].getAttachment().toString());
                    System.out.println(repository.getAll()[i].getStatus());
                    System.out.println();
                }
            } else if (userDo.equals("quit")) {
                isRun = false;
            } else if (userDo.equals("change")) {
                System.out.println("Ввод id дефекта: ");
                long idForChange = scanner.nextLong();
                scanner.nextLine();
                for (Defect defectFromArray:repository.getAll()) {
                    if (idForChange == defectFromArray.getId()) {
                        System.out.println("Ввод статуса дефекта: " + Arrays.toString(DefectStatus.values()));
                        String newStatus = scanner.nextLine();
                        defectFromArray.setStatus(DefectStatus.valueOf(newStatus));
                        break;
                    } else {
                        System.out.println("Ввод некорректного значения");
                    }
                }
            }
        }
    }
}