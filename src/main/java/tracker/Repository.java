package tracker;

import java.util.ArrayList;

public class Repository {
    public static final int DEFECTS_AMOUNT_MAX = 10;
    private Defects [] listOfDefects;
    private int defectsStored = 0;

    public Repository (int DEFECTS_AMOUNT_MAX) {
        this.listOfDefects = new Defects[DEFECTS_AMOUNT_MAX];
    }

    public boolean checkRepositoryIsFull() {
        if (defectsStored >= DEFECTS_AMOUNT_MAX) {
            return true;
        }
        return false;
    }

    public String getRepositoryIsFullText (){
        return "К сожалению, программа пока не может сохранить более " +DEFECTS_AMOUNT_MAX + " дефектов. " +
                "Вы будете возвращены в главное меню.";
    }

    public boolean checkRepositoryIsEmpty () {
        if (defectsStored == 0) {
            return true;
        }
        return false;
    }
    public String getRepositoryIsEmptyText (){
        return  "Пока что вы не завели ни одного дефекта!";
    }


    public void addDefect (Defects listOfDefects) {
        this.listOfDefects[defectsStored] = listOfDefects;
        defectsStored++;
    }

    public Defects [] getAllDefects (){
        return listOfDefects;
    }
}
