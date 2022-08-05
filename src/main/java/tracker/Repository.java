package tracker;
import java.util.Arrays;

public class Repository {

    private final Defect[] defects;
    private int count = 0;

    public Repository (int COUNTOFDEFECTS) {
        this.defects = new Defect[COUNTOFDEFECTS];
    }

    public void add (Defect defect) {
        this.defects[count] = defect;
        count++;
    }

    public Defect [] getAll() {
        return Arrays.copyOf(defects,count);
    }

    public boolean addNewDefect() {
        return count <= defects.length;
    }
    public int getCount (){
        return count;
    }
}
