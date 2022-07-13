package tracker;

public class Repository {
    private final Defect[] defect;
    int count = 0;

    public Repository(int countBug) {
        this.defect = new Defect[countBug];
    }

    public boolean maxCount() {
        return count >= defect.length;
    }

    public void add(Defect defect) {
        this.defect[count] = defect;
        count++;
    }

    public Defect[] getAll() {
        return defect;
    }
}
