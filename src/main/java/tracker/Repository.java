package tracker;

import java.util.Arrays;

public class Repository {
    private final Defect[] defect;
    int count = 0; // todo 3 - не инкапсулированно

    public Repository(int countBug) {
        this.defect = new Defect[countBug];
    }

    public void add(Defect defect) {
        this.defect[count] = defect;
        count++;
    }

    // todo 1 - max count это число, возвращает boolean; название не очень
    public boolean maxCount() {
        return count >= defect.length;
    }

    public Defect[] getAll() {
        return Arrays.copyOf(defect,count);
    }
}
