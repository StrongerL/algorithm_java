package 动态规划;

import java.util.LinkedList;
import java.util.List;

public class 城市路径 {

    public static void main(String[] args) {
        int[][][] road = new int[][][]{
                {{1, 3}, {3, 2}, {2, 1}, {3, 2}, {-1, 4}},
                {{2, 3}, {2, 4}, {1, 1}, {4, 2}, {-1, 3}},
                {{2, 2}, {3, 1}, {4, 2}, {5, 2}, {-1, 3}},
                {{2, -1}, {3, -1}, {1, -1}, {2, -1}, {-1, -1}}
        };
        int[][] length = new int[4][5];

        List<List<Integer>> l = getMinLength(road, length);

        int m = length.length;
        int n = length[0].length;
        System.out.println(length[m - 1][n - 1]);
        for(int[] oo : length) {
            for(int o : oo) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
        for (int i = l.size() - 1; i >= 0; i--) {
            System.out.println("[" + l.get(i).get(0) + " , " + l.get(i).get(1) + "]");
        }

    }

    private static List<List<Integer>> getMinLength(int[][][] road, int[][] length) {

        // 存储具体路径
        List<List<Integer>> ll = new LinkedList<>();

        // m行n列
        int m = length.length;
        int n = length[0].length;

        // 边界条件
        length[0][0] = 0;
        for (int j = 1; j < n; j++)
            length[0][j] = length[0][j - 1] + road[0][j - 1][0];
        for (int i = 1; i < m; i++)
            length[i][0] = length[i - 1][0] + road[i - 1][0][1];

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                length[i][j] = Math.min(length[i - 1][j] + road[i - 1][j][1],
                                        length[i][j - 1] + road[i][j - 1][0]);
            }
        }


        // 一条具体的路径
        int i = m - 1, j = n - 1;
        while (j != 0 || i != 0) {
            List<Integer> l = new LinkedList<>();
            l.add(i);
            l.add(j);
            ll.add(l);
            if (i != 0 && length[i][j] - road[i - 1][j][1] == length[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        List<Integer> l = new LinkedList<>();
        l.add(0);
        l.add(0);
        ll.add(l);

        return ll;
    }


}
