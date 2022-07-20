package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int MAX_DEFECTS = 10; //константа - максимальное количество дефектов
        Repository repository = new Repository(MAX_DEFECTS); //создаём экземпляр класса Repository
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
                    if (count < MAX_DEFECTS) { //проверяем сколько дефектов заведено
                        System.out.println("Введите краткое описание дефекта:");
                        String description = scan.nextLine();//добавляем переменную для занесение в поле description
                        System.out.println("Следующий шаг: введите критичность дефекта" +
                                "\n(Доступны следующие варианты: Тривиальный, Незначительный, Значительный, Критический, Блокирующий)");
                        String severity = scan.nextLine();//добавляем переменную для занесение в поле severity
                        System.out.println("Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
                        int numberOfDays = scan.nextInt();//добавляем переменную для занесение в поле numberOfDays
                        scan.nextLine();
                        Defect defect = new Defect(description, severity, numberOfDays);//создаём объект типа Defect с обязательными полями description, severity, numberOfDays
                        System.out.println("Вы ввели следующий дефект:");
                        System.out.println(defect.getInfoDefect());
                        repository.add(defect);//вызываем метод add для добавления объекта в поле defects переменной repository
                        count++;//увеличиваем счетчик
                    } else {
                        System.out.println("Закончилось место для заведения дефектов!");
                    }
                    break;
                case "list": //команда список дефектов
                    if (count==0) {
                        System.out.println("Дефектов не заведено!");
                    } else {
                        System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление):");
                        Defect[] defectForList = repository.getAll();//создаём объект типа Defect, в который возвращаем имеющиеся дефекты
                        for (int i = 0; i < count; i++) {
                        System.out.println(defectForList[i].getInfoDefect());//применяем метод для каждого дефекта
                        }
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

