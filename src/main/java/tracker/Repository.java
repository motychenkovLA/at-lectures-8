package tracker;

import java.util.Arrays;

public class Repository {

    // todo 3 - public, утечка состояния
    public Defect [] defects;
    // todo 3 - не private, утечка состояния
    // todo 5 - один счетчик на все репозитории, работать с >1 репо не будет
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

    // todo 1 -
    //  метод возвращает наличие свободного места
    //  lengthOfArray звучит так будто возвращается число
    //  boolean геттеры обычно is-что-то называются
    public boolean lengthOfArray () {
        return count < defects.length;
    }

    public Defect [] getAll() {
        return Arrays.copyOf(defects,count);
    }
}


