package 动态规划;


import java.util.Arrays;

public class 合唱队形 {

    public static void main(String[] args) {

        int[] q = new int[]{186, 186, 150, 200, 160, 130, 197, 220};
        System.out.println(getMaxLength(q));

    }

    private static int getMaxLength(int[] q) {

        int n = q.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // 左最大上升子序列
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (q[i] > q[j] && left[j] > max)
                    max = left[j];
            }
            left[i] = max + 1;
        }
        // 右最大上升子序列
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--) {
                if (q[i] > q[j] && right[j] > max)
                    max = right[j];
            }
            right[i] = max + 1;
        }

        int indexOfMaxValue = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] + right[i] > indexOfMaxValue)
                indexOfMaxValue = i;
        }

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        return left[indexOfMaxValue] + right[indexOfMaxValue] - 1;

    }



}
