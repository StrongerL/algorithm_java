import java.util.*;

public class Tmp {

    private int n = 1;
    private char[][] chessboard = new char[][] {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
    };
    private boolean[] left = new boolean[17];
    private boolean[] right = new boolean[17];
    private boolean[] vertical = new boolean[9];
    private List<List<String>> ans = new ArrayList<>();

    private boolean check(int i, int j) {
        return !left[i + j] && !right[i - j + (n - 1)] && !vertical[j];
    }

    private void backtrack(int index) {
        if (index == n) {
            List<String> currentAns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = new String(chessboard[i], 0, n);
                currentAns.add(s);
            }
            ans.add(currentAns);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (check(index, j)) {
                chessboard[index][j] = 'Q';
                vertical[j] = true;
                left[index + j] = true;
                right[index - j + (n - 1)] = true;
                backtrack(index + 1);
                chessboard[index][j] = '.';
                vertical[j] = false;
                left[index + j] = false;
                right[index - j + (n - 1)] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        backtrack(0);
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(3 ^ 2);



    }

}
