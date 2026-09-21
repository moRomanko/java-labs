//29. Для каждого числа из заданной последовательности натуральных чисел
//определить, равна ли его первая цифра 5 и все цифры различны.

import java.util.Scanner;

public class t29 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество чисел:");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Введите " + n + " натуральных чисел (построчно):");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Числа, у которых первая цифра 5 и все цифры различны:");
        for (int num : numbers){
            String s = Integer.toString(num);
            int l = s.length();

            if (s.charAt(0) != '5') continue;

            boolean duplicated = false;
            for (int i = 0; i < l - 1 && !duplicated; i++){
                for (int j=i+1; j < l; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        duplicated = true;
                        break;
                    }
                }
            }

            if (!duplicated) System.out.println(num);
        }
    }
}
