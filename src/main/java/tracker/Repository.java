package tracker;

public class Repository {
    public static final int DEFECTS_AMOUNT_MAX = 10;
    private final Defect[] listOfDefects;
    private int defectsStored = 0;

    public Repository(int DEFECTS_AMOUNT_MAX) {

        this.listOfDefects = new Defect[DEFECTS_AMOUNT_MAX];
    }

    public boolean checkRepositoryIsFull() {
        return defectsStored >= DEFECTS_AMOUNT_MAX;
    }

    public String getRepositoryIsFullText() {
        return "К сожалению, программа пока не может сохранить более " + DEFECTS_AMOUNT_MAX + " дефектов. " +
                "Вы будете возвращены в главное меню.";
    }

    public boolean checkRepositoryIsEmpty() {
        return defectsStored == 0;
    }

    public String getRepositoryIsEmptyText() {

        return "Пока что вы не завели ни одного дефекта!";
    }

    public void addDefect(Defect defect) {
        this.listOfDefects[defectsStored] = defect;
        defectsStored++;
    }

    public Defect[] getAllDefects() {
        return listOfDefects;
    }

    public void printAllDefects() {
        System.out.println("Список дефектов:");
        for (Defect defect : getAllDefects()) {
            if (defect == null) {
                break;
            }
//            System.out.println("Список дефектов:");
            System.out.println(defect.getDefectInfo());
        }
    }
}
