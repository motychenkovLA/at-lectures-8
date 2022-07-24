package tracker;

public class Repository {

    private int amountDefects;
    private Defect[] defects;
    private int countDefects;

    public Repository (int amountDefects) {
        this.amountDefects = amountDefects;
        defects = new Defect[amountDefects];
    }

    public int getCountDefects() {
        return countDefects;
    }

    void add (Defect defect) {
        defects[countDefects] = defect;
        countDefects++;
    }

    Defect[] getAll() {
        return defects;
    }

    public int getDefectsLength() {
        return defects.length;
    }

    public boolean existenceOfSuchID (long defectAttach) {
        boolean existenceOfSuchID = false;
        for (Defect defect : defects) {
            if (defect == null) {
                break;
            }
            else if (defect.getID() == defectAttach) {
                existenceOfSuchID = true;
                break;
            }
        }
        return existenceOfSuchID;
    }

}
