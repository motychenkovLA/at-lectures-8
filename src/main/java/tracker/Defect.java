package tracker;

import java.util.Arrays;

public class Defect {
    final int MaxNumberOfDefects = 10;

    long[] id = new long[MaxNumberOfDefects];
    String[] description = new String[MaxNumberOfDefects];
    String[] severity = new String[MaxNumberOfDefects];
    int[] numberOfDays = new int[MaxNumberOfDefects];

    void printInfo (int currentDefectNumber){
        System.out.println("Вы ввели следующий дефект: " +
                "\n" + description[currentDefectNumber] +
                "\n" + severity[currentDefectNumber] +
                "\n" + numberOfDays[currentDefectNumber] +
                "\n" + id[currentDefectNumber]);
    }


}
