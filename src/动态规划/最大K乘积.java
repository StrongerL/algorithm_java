package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 最大K乘积 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n];
        int i = 0;
        // Ctrl + D结束输入
        while (input.hasNextInt()) {
            a[i++] = input.nextInt();
        }

        System.out.println(getMaxProduct(k, a));
    }


    private static int getMaxProduct(int k, int[] a) {

        int n = a.length;
        int[][] w = new int[n + 1][n + 1];
        int[][] m = new int[n + 1][k + 1];

        // 乘号位置
        int[][] loc = new int[n + 1][k + 1];

        // 初始化w
        for (int i = 1; i <= n; i++) {
            w[i][i] = a[i - 1];
            for (int j = i + 1; j <= n; j++) {
                w[i][j] = w[i][j - 1] * 10 + a[j - 1];
            }
        }

        // 边界条件
        for (int i = 1; i <= n; i++)
            m[i][1] = w[1][i];

        // 状态转移方程
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i && j <= k; j++) {

                int max = Integer.MIN_VALUE;
                int index = j - 1;
                for (int p = j - 1; p < i; p++) {
                    int tmp = m[p][j -1] * w[p + 1][i];
                    if (tmp > max) {
                        max = tmp;
                        index = p;
                    }

                }
                m[i][j] = max;
                loc[i][j] = index;
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println();
        display(w);
        System.out.println();
        display(m);

        int i = n, j = k;
//        while (j > 1) {
//            System.out.println(loc[i][j]);
//            i -=
//        }



        return m[n][k];

    }






    private static void display(int[][] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++)
                System.out.print(nums[i][j] + " ");
            System.out.println();
        }
    }


}
