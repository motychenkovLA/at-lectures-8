package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // todo 3 - 10 это константа
        // todo 3 - дефекты хранятся в виде строк, хотя строками не являются, дефект состоит из нескольких полей разного тип
        String[] arrayOfDefects = new String[10]; //вводим строковый массив arrayOfDefects с количеством элементов 10
        int count = 0; //вводим счетчик
        final int maxDefects = arrayOfDefects.length; //константа - максимальное количество дефектов, равное длинне массива
        // todo 0 - не говорящее название
        boolean flag = true; //флаг завершения цикла
        while (flag) {
            System.out.println("Вы находитесь в главном меню багтрекинговой системы. Выберите действие:" +
                    "\nДобавить новый дефект (введите команду add)" +
                    "\nВывести список дефектов (введите команду list)" +
                    "\nВернуться в главное меню (введите команду quit)");
            String command = scan.nextLine();
            switch (command) {
                case "add": //ввод дефекта
                    // todo 0 - переносы { и отступы
                    if (count < maxDefects ) //проверяем сколько дефектов заведено
                    {
                        System.out.println("Введите краткое описание дефекта:");
                        String description = scan.nextLine();
                        System.out.println("Отлично! Следующий шаг: введите критичность дефекта" +
                                "\n(Доступны следующие варианты: Тривиальный, Незначительный, Значительный, Критический, Блокирующий)");
                        String severity = scan.nextLine();

                        System.out.println("Замечательно! Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
                        int numberOfDays = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Великолепно! Вы ввели следующую информацию по дефекту: " +
                                "\nОписание дефекта: " + description +
                                "\nКритичность дефекта: " + severity +
                                "\nКоличество дней на исправление: " + numberOfDays);

                        arrayOfDefects[count] = description + " " + severity + " " + numberOfDays; //записываем дефект в массив
                        count++;//увеличиваем счетчик
                    }
                    else {
                            System.out.println("Закончилось место для заведения дефектов!");
                        }
                    break;
                case "list": //команда список дефектов
                    System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление):");
                    int countList = count; //вводим ещё один счетчик, равный count // todo 3 - зачем?
                    for (int i = 0; i < countList; i++) { //выводим построково дефекты из массива в количестве i, равному счетчику count
                        System.out.println(arrayOfDefects[i]);
                    }
                    break;
                case "quit":
                    System.out.println("Завершение работы программы");
                    flag = false;
                    break;
                default:
                    System.out.println("Введена некорректная команда, возврат в главное меню");
                    break;
            }
        }
    }
}

