package tracker;

public class Repository {
    private Defect[] arrayDefects;
    private int amountDefects = 0;
    private int amount;

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

    public void changeStatus(String newStatusDefect, Defect defectFromArray) {
        if (StatusDefect.OPEN.toString().equals(newStatusDefect)) {
            defectFromArray.setStatus(StatusDefect.OPEN);
        } else if (StatusDefect.ANALYSIS.toString().equals(newStatusDefect)) {
            defectFromArray.setStatus(StatusDefect.ANALYSIS);
        } else if (StatusDefect.CORRECTION.toString().equals(newStatusDefect)) {
            defectFromArray.setStatus(StatusDefect.CORRECTION);
        } else if (StatusDefect.TESTING.toString().equals(newStatusDefect)) {
            defectFromArray.setStatus(StatusDefect.TESTING);
        } else if (StatusDefect.CLOSE.toString().equals(newStatusDefect)) {
            defectFromArray.setStatus(StatusDefect.CLOSE);
        } else {
            System.out.println("Введите корректное значение");
        }
    }

    public int getAmountDefects() {
        return amountDefects;
    }

    public Defect[] getArrayDefects() {
        return arrayDefects;
    }

    public Repository(int amount) {
        this.amount = amount;
        arrayDefects = new Defect[amount];
    }

    public Repository() {
    }
}
