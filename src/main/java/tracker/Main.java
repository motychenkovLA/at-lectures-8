package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int MAX_DEFECTS = 10; //константа - максимальное количество дефектов
        Defect defect = new Defect(); // вводим переменную типа Defect
        int count = 0; //вводим счетчик
        boolean work = true; //флаг завершения цикла
        long idDefect = 1000000;
        while (work) {
            System.out.println("Вы находитесь в главном меню багтрекинговой системы. Выберите действие:" +
                    "\nДобавить новый дефект (введите команду add)" +
                    "\nВывести список дефектов (введите команду list)" +
                    "\nВернуться в главное меню (введите команду quit)");
            String command = scan.nextLine();
            switch (command) {
                case "add": //ввод дефекта
                    if (count < MAX_DEFECTS) { //проверяем сколько дефектов заведено
                        System.out.println("Введите краткое описание дефекта:");
                        defect.description[count] = scan.nextLine();
                        System.out.println("Следующий шаг: введите критичность дефекта" +
                                "\n(Доступны следующие варианты: Тривиальный, Незначительный, Значительный, Критический, Блокирующий)");
                        defect.severity[count] = scan.nextLine();
                        System.out.println("Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
                        defect.numberOfDays[count] = scan.nextInt();
                        scan.nextLine();
                        defect.id[count] = idDefect++;//увеличиваем id дефекта
                        defect.printInfo(count); //вызываем метод printInfo для вывода дефекта в консоль
                        count++;//увеличиваем счетчик
                    } else {
                        System.out.println("Закончилось место для заведения дефектов!");
                    }
                    break;
                case "list": //команда список дефектов
                    System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление, id дефекта):");
                    for (int i = 0; i < count; i++) { //выводим построково дефекты из массива в количестве i, равному счетчику count
                        System.out.println(defect.description[i] + " // " + defect.severity[i] + " // " + defect.numberOfDays[i] + " // " + defect.id[i]);
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

