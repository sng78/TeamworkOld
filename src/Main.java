import java.util.Scanner;
import java.lang.NumberFormatException;

class Main {
    public static void main(String[] args) {//

        Scanner scanner = new Scanner(System.in);
        int[] marcetProduct = new int[5];
        String[] products = {"Хлеб", "Яблоки", "Молоко", "Яйца", "Колбаса"};
        int[] prices = {100, 200, 300, 150, 400};
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        int sumProducts = 0;
        while (true) {
            int productNumber = 0;
            int productCount = 0;
            System.out.println("Выберите товар и количество или введите `end`");
            try {
                String inputString = scanner.nextLine(); // Считываем номер операции
                if (inputString.equals("end")) {
                    break;
                }
                String[] inputProduct = inputString.split(" ");
                if (inputProduct.length == 2) {//проверка условия ввода двух чисел через пробел
                    productNumber = Integer.parseInt(inputProduct[0]) - 1;
                    productCount = Integer.parseInt(inputProduct[1]);
                } else if (!(inputProduct.length == 2)) {
                    System.out.println("Введите два числа через пробел!");
                }
                if (productNumber + 1 > products.length || ((productNumber + 1) < 0) || ((productCount) < 0)) { //проверка условия корректности ввода двух чисел больше 0 и не больше длины массива
                    System.out.println("Выберите продукт от 1 до " + products.length);
                } else {
                    int currentPrice = prices[productNumber];
                    String currentProduct = products[productNumber];
                    sumProducts += currentPrice * productCount;
                    marcetProduct[productNumber] += productCount; // создаю массив корзины и добавляю в ячеку количество товара
                }
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА! Вы ввели текст вместо числа");
                continue;
            }
        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (marcetProduct[i] > 0) {
                int sumProduct = marcetProduct[i] * prices[i];
                System.out.println(products[i] + " " + marcetProduct[i] + " шт " + prices[i] + " руб/шт " + sumProduct + " руб в сумме");
            }
        }
        System.out.println("Итого: " + sumProducts + " руб");
    }
}
