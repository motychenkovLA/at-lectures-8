package tracker;

public class Repository {
    private Defect[] arrayDefects;
    private int amountDefects = 0;

    public Repository(int amount) {
        arrayDefects = new Defect[amount];
    }

    public void add(Defect defect) {
            arrayDefects[amountDefects] = defect;
            amountDefects++;
    }

    public Defect[] getAll() {
        int lengthArrayForReturn = amountDefects;
        Defect[] defectsForReturn = new Defect[lengthArrayForReturn];
        System.arraycopy(arrayDefects, 0, defectsForReturn, 0, lengthArrayForReturn);
        return defectsForReturn;
    }

    public int getAmountDefects() {
        return amountDefects;
    }

    public String getAllDefectsInfo(){

        String resultString = "";
        for (Defect defect : arrayDefects) {
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

        for (Defect d: arrayDefects){
            if (d != null && d.getId() == id){
                defect = d;
            }
        }
        return defect;
    }
}
