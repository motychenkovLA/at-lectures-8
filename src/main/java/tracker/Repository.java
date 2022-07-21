package tracker;

import java.util.Arrays;

public class Repository {

    public Defect [] defects;
    static int count = 0;
    //конструктор, который на вход принимает максимальное количество дефектов и говорит, что объявляется массив ЭТИХ элементов типа Defect в количестве, равному значению на входе
    public Repository(int maxDefects) {
        this.defects = new Defect[maxDefects];
    }

    //метод add, который говорит, что i-й элемент поля defects = тому значению, который пришёл на вход метода (типа конструктор?)
    public void add (Defect defect) {
        this.defects[count] = defect;
        count++;
    }

    public boolean lengthOfArray () {
        return count < defects.length;
    }

    // todo 3 - возвращает вообще все, включая нуллы, не только сохраненные дефекты
    //  + утечка внутреннего состояния, де-инкапсулирует репо
    public Defect [] getAll() {
        return Arrays.copyOf(defects,count);
    }
}


