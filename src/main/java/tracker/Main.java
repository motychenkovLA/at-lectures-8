package tracker;

import java.util.Scanner;

public class Main {
    public static final String PRIORITY_LOW = "Low";
    public static final String PRIORITY_MEDIUM = "Medium";
    public static final String PRIORITY_HIGH = "High";
    public static final String PRIORITY_CRITICAL = "Critical";
    ///public static final int DEFECTS_AMOUNT_MAX = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Repository repository = new Repository (Repository.DEFECTS_AMOUNT_MAX);
       /// Defects [] listOfDefects = new Defects[DEFECTS_AMOUNT_MAX];
     ///   int defectsStored = 0;
        boolean programmIsOn = true;
        System.out.println("Добро пожаловать!");
        while (programmIsOn) {
            System.out.println("");
            System.out.println("Для продолжения введите одну из команд:");
            System.out.println("1. Для добавления нового дефекта -\"/add\"");
            System.out.println("2. Для просмотра списка дефектов - \"/list\"");
            System.out.println("3. Для выхода из программы - \"/quit\"");
            String action = in.nextLine();
            switch (action) {
                case "/add":
                    if (repository.checkRepositoryIsFull()) {
            ///        if (defectsStored >= DEFECTS_AMOUNT_MAX) {
                        System.out.println(repository.getRepositoryIsFullText());
                        break;
                    }
                    System.out.print("Введите название дефекта: ");
                    String defectName = in.nextLine();
                    String defectPriority = "";
                    boolean isPriorityIncorrect = true;
                    while (isPriorityIncorrect) {
                        System.out.printf("Введите приоритет дефекта ( %s, %s, %s, %s): ",
                                PRIORITY_LOW, PRIORITY_MEDIUM, PRIORITY_HIGH, PRIORITY_CRITICAL);
                        defectPriority = in.nextLine();
                        if (PRIORITY_LOW.equalsIgnoreCase(defectPriority)
                                || PRIORITY_MEDIUM.equalsIgnoreCase(defectPriority)
                                || PRIORITY_HIGH.equalsIgnoreCase(defectPriority)
                                || PRIORITY_CRITICAL.equalsIgnoreCase(defectPriority)) {
                            isPriorityIncorrect = false;
                        }
                    }
                    System.out.print("Введите количество дней на исправление дефекта: ");
                    int defectFixDays = in.nextInt();
                    in.nextLine();
                    Defects defect = new Defects(defectName, defectPriority, defectFixDays);
                    repository.addDefect(defect);
                 ///   listOfDefects [defectsStored] = defect;
                 ///   defectsStored++;
                    System.out.println(defect.getDefectInfo());

                    break;
                case "/list":
                    if (repository.checkRepositoryIsEmpty()) {
               ///     if (defectsStored < 1) {
                        System.out.println(repository.getRepositoryIsEmptyText());
                        break;
                    }
                    for (Defects defectInfo : repository.getAllDefects()){
                        if (defectInfo == null) {
                           break;
                        }
                        System.out.println("Список дефектов:");
                        System.out.println(defectInfo.getDefectInfo());
                    }
                    ///for (int i = 0; i < defectsStored; i++) {
                    ///    System.out.println (listOfDefects[i].getDefectInfo());
                    ///}
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
