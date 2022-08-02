package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Repository repository = new Repository(Repository.DEFECTS_AMOUNT_MAX);
        boolean programmIsOn = true;
        System.out.println("Добро пожаловать!");
        while (programmIsOn) {
            System.out.println("");
            System.out.println("Для продолжения введите одну из команд:");
            System.out.println("1. Для добавления нового дефекта -\"/add\"");
            System.out.println("2. Для просмотра списка дефектов - \"/list\"");
            System.out.println("3. Для изменения статуса дефекта - \"/status\"");
            System.out.println("4. Для выхода из программы - \"/quit\"");
            String action = in.nextLine();
            switch (action) {
                case "/add":
                    if (repository.checkRepositoryIsFull()) {
                        System.out.println(repository.getRepositoryIsFullText());
                        break;
                    }
                    System.out.println("Введите название дефекта: ");
                    String defectName = in.nextLine();
//                    String defectPriority = "";
//                    boolean isPriorityIncorrect = true;
//                    while (isPriorityIncorrect) {
                    System.out.println("Введите приоритет дефекта:");
                    DefectPriority.printPriorityNames();
                    DefectPriority defectPriority = DefectPriority.valueOf(in.nextLine().toUpperCase());
//                    DefectCriticality.getDefectPriorityCheck(in);
//            }
                    System.out.println("Введите количество дней на исправление дефекта: ");
                    int defectFixDays = in.nextInt();
                    in.nextLine();
                    boolean addAttachement = true;
                    while (addAttachement) {
                        System.out.println("Хотите добавить вложение?");
                        System.out.println("1. Для добавления комментария к дефекту введите - /comment");
                        System.out.println("2. Для добавления ссылки на другой дефект введите - /link");
                        System.out.println("3. Если вложение не требуется введите - /no");
                        String attachmentAction = in.nextLine();
                        switch (attachmentAction) {
                            case "/comment":
                                System.out.println("Введите комментарий к дефекту:");
                                CommentAttachment commentAttachment = new CommentAttachment(in.nextLine());
                                Defect defectComment = new Defect(defectName, defectPriority, defectFixDays, commentAttachment);
                                repository.addDefect(defectComment);
                                System.out.println(defectComment.getDefectInfo());
                                addAttachement = false;
                                break;
                            case "/link":
                                System.out.println("Введите ID дефекта для ссылки:");
                                DefectAttachment defectAttachment = new DefectAttachment(Long.parseLong(in.nextLine()));
                                Defect defectLink = new Defect(defectName, defectPriority, defectFixDays, defectAttachment);
                                repository.addDefect(defectLink);
                                System.out.println(defectLink.getDefectInfo());
                                addAttachement = false;
                                break;
                            case "/no":
                                Defect defect = new Defect(defectName, defectPriority, defectFixDays);
                                repository.addDefect(defect);
                                System.out.println(defect.getDefectInfo());
                                addAttachement = false;
                                break;
                            default:
                                System.out.println("Упс!");
                                System.out.println("Укажите одну из предложенных команд - другие я пока исполнять не умею :(");
                                break;
                        }
                    }
                    break;
                case "/list":
                    if (repository.checkRepositoryIsEmpty()) {
                        System.out.println(repository.getRepositoryIsEmptyText());
                        break;
                    }
                    repository.printAllDefects();
                    break;
                case "/status":
                    if (repository.checkRepositoryIsEmpty()) {
                        System.out.println(repository.getRepositoryIsEmptyText());
                        break;
                    }
                    System.out.println("Введите ID дефекта, которому необходимо сменить статус:");
                    long defectId = in.nextLong();
                    in.nextLine();
                    System.out.println("Введите актуальный статус дефекта:");
                    DefectStatus.printStatusNames();
                    DefectStatus defectStatus = DefectStatus.valueOf(in.nextLine().toUpperCase());
                    System.out.println(defectStatus);
                    for (Defect defect : repository.getAllDefects()){
                        if (defectId == defect.getId()){
                            System.out.println(defectId);
                            System.out.println(defect.getId());
                            defect.setStatus(defectStatus);
                            System.out.println("Success");
                        }
                        break;
                    }
                    break;
                case "/quit":
                    programmIsOn = false;
                    System.out.println("Вы вышли из программы. До скорой встречи! :)");
                    break;
                default:
                    System.out.println("Упс!");
                    System.out.println("Укажите одну из предложенных команд - другие я пока исполнять не умею :(");
                    break;
            }
        }
    }
}
