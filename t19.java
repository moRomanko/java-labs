//19. Найти и вывести все четырёхзначные числа из заданной последовательности
//целых чисел. Подсчитать количество четырёхзначных чисел, сумма цифр которых равна
//заданному числу k.

import java.util.Scanner;

public class t19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество чисел:");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел (построчно):");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Введите число k:");
        int k = sc.nextInt(), countDigSum = 0;

        System.out.println("Введённые четырёхзначние числа:");

        for (int num : numbers) {
            n = Math.abs(num);
            if (n >= 1000 && n <= 9999) System.out.println(num);
            else continue;

            if (n/1000 + (n/100)%10 + (n/10)%10 + n%10 == k) {
                countDigSum++;
            }
        }
        System.out.println("Количество четырёхзначных чисел, сумма цифр которых равна " + k + ": " + countDigSum);
    }
}