package tracker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    private final Map <Long, Defect> repository= new HashMap <> ();
    //private final Defect [] defects;
    //конструктор, который на вход принимает максимальное количество дефектов и говорит, что объявляется массив ЭТИХ элементов типа Defect в количестве, равному значению на входе
    // public Repository(int maxDefects) {
    //    this.defects = new Defect[maxDefects];
    //}

    public void add (Defect defect){
        repository.put(defect.getId(), defect);
    }

    public boolean isEmpty () {
          return repository.isEmpty();
    }

    public Collection<Defect> getAll () {
        return repository.values();
    }

    public boolean checkId (long id) {
        return repository.containsKey(id);
    }

    public Defect getDefect (long id) {
        return repository.get(id);
    }
}


