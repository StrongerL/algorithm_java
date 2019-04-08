package 动态规划;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 背包01 {


    public static void main(String[] args) {

        // 物品重量
        int[] w = new int[]{2, 2, 6, 5, 4};
        // 物品价值
        int[] v = new int[]{6, 3, 5, 4, 6};
        // 背包容量
        int c = 10;

        List<Integer> l = getBackpackList(c, v, w);

        System.out.println(Arrays.toString(l.toArray()));

    }

    private static List<Integer> getBackpackList(int c, int[] v, int[] w) {

        int n = v.length;
        int[][] res = new int[n][c + 1];
        // 边界条件
        for (int j = 1; j <= c; j++) {
            if (w[0] > j)
                res[0][j] = 0;
            else
                res[0][j] = v[0];
        }
        // 转换方程
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i] > j)
                    res[i][j] = 0;
                else
                    res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - w[i]] + v[i]);
            }
        }

        for (int[] oo : res) {
            for (int o : oo)
                System.out.print(o + " ");
            System.out.println();
        }

        // 逆推获取放入的物品
        List<Integer> l = new LinkedList<>();
        int i = n - 1;
        while (i > 0) {
            if (res[i][c] != res[i - 1][c]) {
                l.add(0, i);
                c -= w[i];
            }
            i--;
        }
        if (res[0][c] != 0)
            l.add(0, 0);
        return l;
    }

}
