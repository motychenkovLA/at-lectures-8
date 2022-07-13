package tracker;

public class Repository {
    private final Defect[] defect;
    // todo 3 - утекает внутреннее состояние
    int count = 0;

    public Repository(int countBug) {
        this.defect = new Defect[countBug];
    }

    public void add(Defect defect) {
        this.defect[count] = defect;
        count++;
    }

    public boolean maxCount() {
        return count >= defect.length;
    }

    // todo 3+ - возвращает не все дефекты, а все дефекты + горсть нуллов
    //  + утекает внутреннее состояние, нарушая инкапсуляцию
    public Defect[] getAll() {
        return defect;
    }
}
