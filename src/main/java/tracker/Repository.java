package tracker;

public class Repository {
    private Defect[] arrayDefects;
    // todo * - по названиям amount и amountDefect не ясно в чем разница
    private int amountDefects = 0;
    private int amount; // todo * - поле не используется

    public void add(Defect defect) {
        if (amountDefects < arrayDefects.length) {
            arrayDefects[amountDefects] = defect;
            amountDefects++;
        } else {
            // todo * - репо не должен работать с консолью
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

    // todo * - метод для утечки внутреннего состояния и нарушения инкапсуляции + не используется
    public Defect[] getArrayDefects() {
        return arrayDefects;
    }

    // todo * - конструктор перед методами объявляют
    public Repository(int amount) {
        this.amount = amount;
        arrayDefects = new Defect[amount];
    }

    // todo * - невалидно конструирует объект + не используется
    public Repository() {
    }
}
