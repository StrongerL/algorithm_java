## 代码

```java
class Solution {
    
    int[][] direcs = new int[][] {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };
    int ans = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        dfs(vis, 0, 0, k);
        return ans;
    }

    private void dfs(boolean[][] vis, int i, int j, int k) {
        vis[i][j] = true;
        ans++;
        for (int[] direc : direcs) {
            int newI = i + direc[0];
            int newJ = j + direc[1];
            if (check(vis, newI, newJ, k)) {
                dfs(vis, newI, newJ, k);
            }
        }
    }

    private boolean check(boolean[][] vis, int i, int j, int k) {
        return i >= 0 && i < vis.length && j >= 0 && j < vis[0].length && !vis[i][j]
                && lessOrEqualsK(i, j, k);
    }

    private boolean lessOrEqualsK(int i, int j, int k) {
        int sum = 0;
        while (i > 0) {
            sum += (i % 10);
            i /= 10;
        }
        while (j > 0) {
            sum += (j % 10);
            j /= 10;
        }
        return sum <= k;
    }

}
```

## 思路

dfs，需要进一步优化解法。

## 参考

无。