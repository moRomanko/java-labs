//9. Вычислить определитель матрицы.

public class l2t9 {
    public static void main(String[] args){

        int[][] matrix = matrixPut.inputMatrix();
        System.out.println("Исходная матрица:");
        matrixPut.matrixPrint(matrix);

        if (matrix.length != matrix[0].length){
            System.out.print("Матрица не является квадратной. Определитель не может быть вычислен.");
        }

        else{
            System.out.print("Определитель матрицы равен " + computeDeterminant(matrix) + ".");
        }

    }

    public static int computeDeterminant(int[][] matrix){

        int n = matrix.length;

        if (n == 1){
            return matrix[0][0];
        }

        else if (n == 2){
            return matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];
        }

        int res = 0;
        for (int col = 0; col < n; col++) {
            int[][] minor = getMinor(matrix, 0, col);
            res += (int) Math.pow(-1, col) * matrix[0][col] * computeDeterminant(minor);
        }

        return res;
    }

    private static int[][] getMinor(int[][] matrix, int excludedRow, int excludedCol) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];

        int mi = 0;
        for (int i = 0; i < n; i++) {
            if (i == excludedRow) {
                continue;
            }

            int mj = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludedCol) {
                    continue;
                }

                minor[mi][mj] = matrix[i][j];
                mj++;
            }

            mi++;
        }

        return minor;
    }
}
