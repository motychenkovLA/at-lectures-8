package tracker;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuForInn {
      Scanner scanner = new Scanner(System.in);
      String userDo;
      String resume;
      Criticality criticality;
      int amountDays;
      String typeAttachment;
      Attachment attachment;

    public String doIn() {
        System.out.println("Выберите действие: добавить новый дефект (\"add\"), " +
                "вывести список (\"list\"), " + "изменить статус (\"change\"), " + "выйти из программы (\"quit\") - главное меню");
        //объявляем и вводим переменную действия пользователя
        String userDo = scanner.nextLine();
        return userDo;
    }

    public String resumeDefectIn() {
        System.out.println("Введите резюме дефекта");
        String resume = scanner.nextLine();
        return resume;
    }

    public Criticality criticalityDefectIn() {
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

    public int amountDayIn() {
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

    public Attachment typeAttachmentIn() {
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

    public String getUserDo() {
        return userDo;
    }

    public void setUserDo(String userDo) {
        this.userDo = userDo;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Criticality getCriticality() {
        return criticality;
    }

    public void setCriticality(Criticality criticality) {
        this.criticality = criticality;
    }

    public int getAmountDay() {
        return amountDays;
    }

    public void setAmountDay(int amountDay) {
        this.amountDays = amountDay;
    }

    public String getTypeAttachment() {
        return typeAttachment;
    }

    public void setTypeAttachment(String typeAttachment) {
        this.typeAttachment = typeAttachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
