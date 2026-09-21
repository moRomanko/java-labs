//9. Найти все пятизначные натуральные числа из заданной последовательности
//чисел и подсчитать их количество, в которых средняя цифра равна сумме крайних цифр.

import java.util.Scanner;
public class t9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество чисел:");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел (построчно):");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int countFiveDig = 0, countDigSum = 0;

        for (int num : numbers) {
            if (num >= 10000 && num <= 99999) {
                countFiveDig++;
            } else {
                continue;
            }

            if ((num / 100) % 10 == num / 10000 + num % 10) {
                countDigSum++;
            }
        }

        System.out.println("Количество натуральных пятизначных чисел: " + countFiveDig);
        System.out.println("Количество таких пятизначных чисел, в которых средняя цифра равна сумме крайних цифр: " + countDigSum);
    }
}