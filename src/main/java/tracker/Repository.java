package tracker;

public class Repository {
    private Defect[] arrayDefects;
    private int amountDefects = 0;

    public Repository(int amount) {
        arrayDefects = new Defect[amount];
    }

    public void add(Defect defect) {
            arrayDefects[amountDefects] = defect;
            amountDefects++;
    }

    public Defect[] getAll() {
        int lengthArrayForReturn = amountDefects;
        Defect[] defectsForReturn = new Defect[lengthArrayForReturn];
        System.arraycopy(arrayDefects, 0, defectsForReturn, 0, lengthArrayForReturn);
        return defectsForReturn;
    }

    public int getAmountDefects() {
        return amountDefects;
    }

    public Defect[] getArrayDefects() {
        return arrayDefects;
    }
}
