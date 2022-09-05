package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository(Repository.DEFECTS_AMOUNT_MAX);
        boolean programmIsOn = true;
        System.out.println("Добро пожаловать!");
        try (Scanner userInput = new Scanner(System.in)) {
            while (programmIsOn) {
                System.out.println();
                System.out.println("Для продолжения введите одну из команд:");
                System.out.println("1. Для добавления нового дефекта -\"/add\"");
                System.out.println("2. Для просмотра списка дефектов - \"/list\"");
                System.out.println("3. Для изменения статуса дефекта - \"/status\"");
                System.out.println("4. Для выхода из программы - \"/quit\"");
                String action = userInput.nextLine();
                switch (action) {
                    case "/add":
                        if (repository.checkRepositoryIsFull()) {
                            System.out.println(repository.getRepositoryIsFullText());
                            break;
                        }
                        System.out.println("Введите название дефекта: ");
                        String defectName = userInput.nextLine();
                        System.out.println("Введите приоритет дефекта:");
                        DefectPriority.printPriorityNames();
                        DefectPriority defectPriority;
                        while (true) {
                            try {
                                defectPriority = DefectPriority.valueOf(userInput.nextLine().toUpperCase());
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Введите приоритет из списка существующих!");
                            }
                        }
                        System.out.println("Введите количество дней на исправление дефекта: ");
                        float defectFixDays;
                        while (true) {
                            try {
                                defectFixDays = Float.parseFloat(userInput.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Необходимо ввести число!");
                            }
                        }
                        boolean addAttachement = true;
                        while (addAttachement) {
                            System.out.println("Хотите добавить вложение?");
                            System.out.println("1. Для добавления комментария к дефекту введите - /comment");
                            System.out.println("2. Для добавления ссылки на другой дефект введите - /link");
                            System.out.println("3. Если вложение не требуется введите - /no");
                            String attachmentAction = userInput.nextLine();
                            switch (attachmentAction) {
                                case "/comment":
                                    System.out.println("Введите комментарий к дефекту:");
                                    CommentAttachment commentAttachment = new CommentAttachment(userInput.nextLine());
                                    Defect defectComment = new Defect(defectName, defectPriority, defectFixDays,
                                            commentAttachment);
                                    repository.addDefect(defectComment);
                                    System.out.println(defectComment.getDefectInfo());
                                    addAttachement = false;
                                    break;
                                case "/link":
                                    System.out.println("Введите ID дефекта для ссылки:");
                                    long defectAttachmentId;
                                    while (true) {
                                        try {
                                            defectAttachmentId = Long.parseLong(userInput.nextLine());
                                            break;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Необходимо ввести число!");
                                        }
                                    }
                                    if (!repository.checkIdExistence(defectAttachmentId)) {
                                        System.out.println("Дефекта с таким ID не существует!");
                                        repository.printAllDefects();
                                    } else {
                                        DefectAttachment defectAttachment = new DefectAttachment(defectAttachmentId);
                                        Defect defectLink = new Defect(defectName, defectPriority, defectFixDays,
                                                defectAttachment);
                                        repository.addDefect(defectLink);
                                        System.out.println(defectLink.getDefectInfo());
                                        addAttachement = false;
                                    }
                                    break;
                                case "/no":
                                    Defect defect = new Defect(defectName, defectPriority, defectFixDays);
                                    repository.addDefect(defect);
                                    System.out.println(defect.getDefectInfo());
                                    addAttachement = false;
                                    break;
                                default:
                                    System.out.println("Упс!");
                                    System.out.println("Укажите одну из предложенных команд - " +
                                            "другие я пока исполнять не умею :(");
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
                        long defectId;
                        while (true) {
                            try {
                                defectId = Long.parseLong(userInput.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Необходимо ввести число!");
                            }
                        }
                        if (!repository.checkIdExistence(defectId)) {
                            System.out.println("Дефекта с таким ID не существует! " +
                                    "Введите команду /list для ознакомления со списком дефектов");
                        } else {
                            System.out.println("Введите актуальный статус дефекта:");
                            DefectStatus.printStatusNames();
                            DefectStatus defectStatus;
                            try {
                                DefectStatus.valueOf(userInput.nextLine().toUpperCase());
                            } catch (IllegalArgumentException e){
                                System.out.println("Введите существующий статус!");
                            }
                            defectStatus = DefectStatus.valueOf(userInput.nextLine().toUpperCase());
                            for (Defect defect : repository.getAllDefects()) {
                                if (defectId == defect.getId()) {
                                    defect.setStatus(defectStatus);
                                    System.out.println("Статус дефекта изменён!");
                                }
                                break;
                            }
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
}
