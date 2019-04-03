package 回溯;

public class N后问题 {

    private static int[][] matrix;
    private static int[] column;
    private static int[] left;
    private static int[] right;
    private static int count;

    static int times;


    public static void main(String[] args) {

        System.out.println(nQueue(4));

        System.out.println(times);

    }

    private static int nQueue(int n) {
        count = 0;
        matrix = new int[n][n];
        column = new int[n];
        left = new int[2 * n - 1];
        right = new int[2 * n - 1];
        return nQueue(n, 0);
    }

    private static int nQueue(int n, int i) {

        times++;

        for (int j = 0; j < n; j++) {
            // 如果位置符合条件
            if (column[j] == 0 && left[i + j] == 0 && right[i - j + n - 1] == 0) {
                // 放皇后
                matrix[i][j] = 1;
                column[j] = 1;
                left[i + j] = 1;
                right[i - j + n - 1] = 1;


                // 如果已到最后一行
                if (i == n - 1){
                    printMatrix(matrix);
                    count++;
                } else { // 否则继续探索下一行
                    nQueue(n, i + 1);
                }

                // 移除皇后
                matrix[i][j] = 0;
                column[j] = 0;
                left[i + j] = 0;
                right[i - j + n - 1] = 0;
            }
        }
        return count;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }




}
