package tracker;

import java.util.Arrays;

public class Repository {

    public Defect [] defects;
    private int count = 0;

    //конструктор, который на вход принимает максимальное количество дефектов и говорит, что объявляется массив ЭТИХ элементов типа Defect в количестве, равному значению на входе
    public Repository(int MAX_DEFECTS) {
        this.defects = new Defect[MAX_DEFECTS];
    }

    //метод add, который говорит, что i-й элемент поля defects = тому значению, который пришёл на вход метода (типа конструктор?)
    public void add (Defect defect) {
        this.defects[count] = defect;
        count++;
    }

    public Defect [] getAll() {
        return defects;
    }
}


