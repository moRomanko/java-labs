import java.util.Scanner;
public class matrixPut {
    public static int[][] inputMatrix() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Количество строк: ");
    int n = sc.nextInt();

    System.out.print("Количество столбцов: ");
    int m = sc.nextInt();

    int[][] matrix = new int[n][m];

    System.out.println("Вы хотите ввести элеманты матрицы вручную? (True - да, False - случайное заполнение)");

    boolean ans = sc.nextBoolean();

    if (ans) {
        System.out.println("Введите элементы матрицы (построчно):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    else {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (int)(Math.random() * 20) - 10;
            }
        }
    }

    return matrix;

    }

    public static void matrixPrint(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
