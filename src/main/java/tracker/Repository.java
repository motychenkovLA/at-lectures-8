package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private Map<Long, Defect> mapDefect;

    public Repository() {
        mapDefect = new HashMap<>();
    }

    public Map<Long, Defect> getMapDefect() {
        return mapDefect;
    }

        public void add(Long id, Defect defect) {
            mapDefect.put(id, defect);
    }

        public int getAmountDefects() {
        return mapDefect.size();
    }

    public String getAllDefectsInfo(){

        String resultString = "";
        for (Defect defect : mapDefect.values()) {
            if (defect != null) {
                resultString += defect.toString() + "\n";
            }
        }
        if (resultString.equals("")){
            resultString = "Нет ни одного дефекта";
        }

        return resultString;
    }

        public Defect getDefectById(long id){
        Defect defect = null;

        if(mapDefect.containsKey(id)){
            defect = mapDefect.get(id);
        }
        return defect;
    }
}
