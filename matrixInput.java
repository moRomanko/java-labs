import java.util.Scanner;
public class matrixInput {public static int[][] inputMatrix() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Количество строк: ");
    int n = sc.nextInt();

    System.out.print("Количество столбцов: ");
    int m = sc.nextInt();

    int[][] matrix = new int[n][m];

    System.out.println("Введите элементы матрицы (построчно):");

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            matrix[i][j] = sc.nextInt();
        }
    }

    return matrix;
}
}
