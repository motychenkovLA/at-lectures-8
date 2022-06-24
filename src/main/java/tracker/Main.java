package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int maxDefects = 10; //константа - максимальное количество дефектов
        String[] description = new String[maxDefects];//вводим строковый массив description с количеством элементов, равному максимальному кол-ву дефектов
        String[] severity = new String[maxDefects];//вводим строковый массив severity с количеством элементов, равному максимальному кол-ву дефектов
        int[] numberOfDays = new int[maxDefects];//вводим числовой массив numberOfDays с количеством элементов, равному максимальному кол-ву дефектов
        int count = 0; //вводим счетчик
        boolean work = true; //флаг завершения цикла
        while (work) {
            System.out.println("Вы находитесь в главном меню багтрекинговой системы. Выберите действие:" +
                    "\nДобавить новый дефект (введите команду add)" +
                    "\nВывести список дефектов (введите команду list)" +
                    "\nВернуться в главное меню (введите команду quit)");
            String command = scan.nextLine();
            switch (command) {
                case "add": //ввод дефекта
                    if (count < maxDefects) {//проверяем сколько дефектов заведено
                        System.out.println("Введите краткое описание дефекта:");
                        description[count] = scan.nextLine();
                        System.out.println("Следующий шаг: введите критичность дефекта" +
                                "\n(Доступны следующие варианты: Тривиальный, Незначительный, Значительный, Критический, Блокирующий)");
                        severity[count] = scan.nextLine();
                        System.out.println("Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
                        numberOfDays[count] = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Вы ввели следующий дефект: " +
                                "\n" + description[count] +
                                "\n" + severity[count] +
                                "\n" + numberOfDays[count]);
                        count++;//увеличиваем счетчик
                    } else {
                        System.out.println("Закончилось место для заведения дефектов!");
                    }
                    break;
                case "list": //команда список дефектов
                    System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление):");
                    for (int i = 0; i < count; i++) { //выводим построково дефекты из массива в количестве i, равному счетчику count
                        System.out.println(description[i] + " // " + severity[i] + " // " + numberOfDays[i]);
                    }
                    break;
                case "quit":
                    System.out.println("Завершение работы программы");
                    work = false;
                    break;
                default:
                    System.out.println("Введена некорректная команда, возврат в главное меню");
                    break;
            }
        }
    }
}

