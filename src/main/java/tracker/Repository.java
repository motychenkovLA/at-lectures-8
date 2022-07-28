package tracker;
import java.util.Arrays;

public class Repository {

    private final Defect[] defect;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public Repository(int countBug) {
        this.defect = new Defect[countBug];
    }

    public void add(Defect defect) {
        this.defect[count] = defect;
        count++;
    }

    public boolean full() {
        return count >= defect.length;
    }

    public Defect[] getAll() {
        return Arrays.copyOf(defect, count);
    }
}
