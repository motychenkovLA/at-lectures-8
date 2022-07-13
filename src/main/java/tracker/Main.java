package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int MAX_DEFECTS = 10; //константа - максимальное количество дефектов
        String [] arrayOfDefects = new String[MAX_DEFECTS]; //массив для хранения дефектов
        int count = 0; //вводим счетчик
        boolean work = true; //флаг завершения цикла
        long idDefect = 1000000; //начальный id дефекта
        while (work) {
            System.out.println("Вы находитесь в главном меню багтрекинговой системы. Выберите действие:" +
                    "\nДобавить новый дефект (введите команду add)" +
                    "\nВывести список дефектов (введите команду list)" +
                    "\nВернуться в главное меню (введите команду quit)");
            String command = scan.nextLine();
            switch (command) {
                case "add": //ввод дефекта
                    if (count < MAX_DEFECTS) { //проверяем сколько дефектов заведено
                        Defect defect = new Defect();
                        System.out.println("Введите краткое описание дефекта:");
                        defect.description = scan.nextLine();
                        System.out.println("Следующий шаг: введите критичность дефекта" +
                                "\n(Доступны следующие варианты: Тривиальный, Незначительный, Значительный, Критический, Блокирующий)");
                        defect.severity = scan.nextLine();
                        System.out.println("Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
                        defect.numberOfDays = scan.nextInt();
                        scan.nextLine();
                        defect.id = idDefect++;//увеличиваем id дефекта
                        defect.printInfoDefect(); //вызываем метод printInfo для вывода дефекта в консоль
                        arrayOfDefects[count] = defect.getInfoDefect(); //вызываем метод getInfoDefect для записи дефекта в массив
                        count++;//увеличиваем счетчик
                    } else {
                        System.out.println("Закончилось место для заведения дефектов!");
                    }
                    break;
                case "list": //команда список дефектов
                    System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление, id дефекта):");
                   for (int i = 0; i < count; i++) { //выводим построково дефекты из массива в количестве i, равному счетчику count
                       System.out.println(arrayOfDefects[i]);
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

