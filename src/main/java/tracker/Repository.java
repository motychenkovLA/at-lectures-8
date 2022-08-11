package tracker;

import java.util.*;

public class Repository {

    private final Map<Long, Defect> listDefect = new HashMap<>();

    public void add(Defect defect) {
        listDefect.put(defect.getId(), defect);
    }
    public Collection<Defect> getAll() {
        return listDefect.values();
    }

    public Defect getId (long id) {
        return listDefect.get(id);
    }
}
