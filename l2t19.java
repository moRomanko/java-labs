//19. Найти количество всех седловых точек матрицы. (Матрица А имеет
//седловую точку Аi,j, если Аi,j является минимальным элементом в i-й строке и
//максимальным в j-м столбце). Отсортировать строки матрицы по количеству
//седловых точек в строке.

public class l2t19 {
    public static void main(String[] args) {

        int[][] matrix = matrixPut.inputMatrix();
        System.out.println("Исходная матрица:");
        matrixPut.matrixPrint(matrix);

        int[] saddleRowCount = findSaddlePoints(matrix);
        System.out.println("В заданной матрице всего " + saddleRowCount[saddleRowCount.length-1] + " седловых точек.");

        int [][] sortedMatrix = bubbleSort(matrix, saddleRowCount);
        System.out.println("Матрица, отсортированная по количеству седловых точек в строке (по возрастанию):");
        matrixPut.matrixPrint(sortedMatrix);
    }


    public static int[] findSaddlePoints(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        int[] saddlePoints = new int[n+1]; // [i] - в i строке, [length-1] - всего точек в матрице,

        for (int i = 0; i < n; i++) {
            int rowMin = matrix[i][0];

            for (int j = 1; j < m; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }

            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == rowMin) {

                    boolean isMaxInColumn = true;

                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] > matrix[i][j]) {
                            isMaxInColumn = false;
                            break;
                        }
                    }

                    if (isMaxInColumn) {
                        saddlePoints[saddlePoints.length-1]++;
                        saddlePoints[i]++;
                    }
                }
            }
        }
        return saddlePoints;
    }

    public static int[][] bubbleSort(int[][] matrix, int[] saddlePoints){
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - i - 1; j++) {

                if (saddlePoints[j] > saddlePoints[j + 1]) {
                    int tempCount = saddlePoints[j];
                    saddlePoints[j] = saddlePoints[j + 1];
                    saddlePoints[j + 1] = tempCount;

                    int[] tempRow = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = tempRow;
                }
            }
        }
        return matrix;
    }

}
