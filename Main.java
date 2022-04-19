package Singleton;

import java.util.*;

public class Main {

    public static int input(Scanner scanner, Logger logger) {
        int inputValue = 0;
        try {
            inputValue = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException ex) {
            System.out.println("Вы ввели не целое число");
            logger.log("Введено не целочисленное значение");
        }
        return inputValue;
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка: ");
        int size = input(scanner, logger);
        System.out.println("Введите верхнюю границу для значений: ");
        int maxValue = input(scanner, logger);
        logger.log("Создаем и наполняем список");
        List<Integer> source = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            source.add(random.nextInt(maxValue));
        }
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        int threshold = input(scanner, logger);
        Filter filter = new Filter(threshold);
        logger.log("Запускаем фильтрацию");
        List<Integer> result = filter.filterOut(source);
        logger.log("Фильтрацию прошло " + result.size() + " элементов из " + source.size());
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        logger.log("Завершаем программу");
    }
}
