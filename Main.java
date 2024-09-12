import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class FindMaxR {

    // Константы
    private static int size = 1000;
    private static int max = 10000;
    private static int divisor = 14;

    public static void main(String[] args) {
        // Генерация последовательности случайных чисел
        int[] sequence = generateRandomSequence(size, max);
        // Поиск максимального R
        int maxR = findMaxR(sequence);
        // Вывод результата
        if (maxR != -1) {
            System.out.println("Максимальноe R, удовлетворяющее условиям: " + maxR);
        } else {
            System.out.println("-1 (нет подходящего числа R)");
        }
    }
    // Метод для генерации последовательности случайных чисел
    private static int[] generateRandomSequence(int size, int maxValue) {
        Random random = new Random();
        int[] sequence = new int[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = random.nextInt(maxValue + 1); // Генерация числа от 0 до 10000
        }
        return sequence;
    }
    // Метод для поиска максимального R
    private static int findMaxR(int[] sequence) {
        Set<Integer> products = new HashSet<>();

        // Вычисление всех произведений двух различных элементов последовательности
        for (int i = 0; i < sequence.length; i++) {
            for (int j = i + 1; j < sequence.length; j++) {
                int product = sequence[i] * sequence[j];
                if (product <= max) {
                    products.add(product);
                }
            }
        }
        int maxR = -1;
        // Поиск максимального R, кратного 14
        for (int product : products) {
            if (product % divisor == 0 && product > maxR) {
                maxR = product;
            }
        }
        return maxR; // Возвращаем найденное значение R или -1, если ничего не найдено
    }
}
