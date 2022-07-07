package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //объявляем макисмальный размер массива
        final int MAX_DEFECT_COUNT = 10;
        //объявляем массив дефектов
        Defect[] Defects = new Defect[MAX_DEFECT_COUNT];
        //переменная отвечающая за работу цикла
        boolean isRun = true;
        //счетчик заполнения массива
        int amountDefects = 0;
        //номер дефекта
        long id = 1000000;
        //цикл для выбора действия пользователя
        while (isRun) {
            System.out.println("Выберите действие: добавить новый дефект (\"add\"), " +
                    "вывести список (\"list\"), выйти из программы (\"quit\") - главное меню");
            //объявляем и вводим переменную действия пользователя
            String userDo = scanner.nextLine();
            //условный оператор с условием добавления дефекта
            if (userDo.equals("add")) {
                //условный оператор, позволяющий вводить нужное количество дефектов
                if (amountDefects < MAX_DEFECT_COUNT) {
                    System.out.println("Введите резюме дефекта");
                    String resume = scanner.nextLine();
                    System.out.println("Введите критичность дефекта (Highest, high, middle, low):");
                    String criticality = scanner.nextLine();
                    System.out.println("Введите ожидамое количество дней на исправление дефекта");
                    int amountDays = scanner.nextInt();
                    scanner.nextLine();
                    //выводим информацию о дефекте
                    System.out.println("Информация о дефекте: ");
                    System.out.println("Id " + id + " | " + "Резюме: " + resume + " | " + "Серьезность " + criticality +
                            " | " + "Количество дней на исправление " + amountDays);
                    //объявляем экзмепляр класса
                    Defect defect = new Defect(id++, resume, criticality, amountDays);
                    //заносим дефект в массив
                    Defects[amountDefects] = defect;
                    //счетчик зенесенных дефектов
                    amountDefects++;
                    //условие, если место в массиве дефектов закончилось
                } else {
                    System.out.println("Закончилось место, невозможно ввести новый дефект");
                }
                //если пользователь хочет вывести дефекты на экран
            } else if (userDo.equals("list")) {
                //цикл для вывода массива дефектов
                for (int i = 0; i < amountDefects; i++) {
                    System.out.println(Defects[i].getId());
                    System.out.println(Defects[i].getAmountForCorrect());
                    System.out.println(Defects[i].getCriticality());
                    System.out.println(Defects[i].getResume());
                    System.out.println();
                }
                //выход из цикла
            } else if (userDo.equals("quit")) {
                isRun = false;
                //если пользователь ввел некорреткное значение
            } else {
                System.out.println("Введите корректное значение");
            }
        }
    }
}

