## 代码

```java
class Solution {
    
    boolean[][] vis;
    boolean solved;
    char[][] board;

    int[][] directions = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public boolean exist(char[][] board, String word) {
        this.board = board;
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backtrack(i, j, 0, word);
                }
            }
        }
        return solved;
    }

    private void backtrack(int i, int j, int idx, String word) {
        if (solved) return;
        if (idx == word.length() - 1) {
            solved = true;
            return;
        }
        vis[i][j] = true;
        char c = word.charAt(idx + 1);
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length
                && !vis[newI][newJ] && c == board[newI][newJ]) {
                backtrack(newI, newJ, idx + 1, word);
            }
        }
        vis[i][j] = false;
    }
}
```

## 思路

回溯、DFS。

## 参考

无。