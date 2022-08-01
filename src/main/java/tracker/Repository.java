package tracker;

import java.util.Arrays;

public class Repository {

    private final Defect [] defects;
    private int count = 0;
    //конструктор, который на вход принимает максимальное количество дефектов и говорит, что объявляется массив ЭТИХ элементов типа Defect в количестве, равному значению на входе
    public Repository(int maxDefects) {
        this.defects = new Defect[maxDefects];
    }

    //метод add, который говорит, что i-й элемент поля defects = тому значению, который пришёл на вход метода (типа конструктор?)
    public void add (Defect defect) {
        this.defects[count] = defect;
        count++;
    }

    public boolean isNotFull () {
        return count <= defects.length;
    }

    public Defect [] getAll() {
        return Arrays.copyOf(defects,count);
    }

    // todo 1 - чем это отличается эт геттера для count? почему тогда не getCount?
    public int ifEmpty() {
        return count;
    }

}


