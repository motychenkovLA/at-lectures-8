package tracker;

public class Repository {
    Defect[] arrayDefects;
    private int amountDefects = 0;
    int amount;

    public void add(Defect defect) {
        if (amountDefects < arrayDefects.length) {
            arrayDefects[amountDefects] = defect;
            amountDefects++;
        } else {
            System.out.println("Закончилось место, невозможно ввести новый дефект");
        }
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

    public Repository(int amount) {
        this.amount = amount;
        arrayDefects = new Defect[amount];
    }

    public Repository() {
    }
}
