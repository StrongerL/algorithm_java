import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int n;
    private int len = 1;
    private boolean[] vis;
    private List<Integer> ans = new ArrayList<>();
    private List<Integer> ans1;
    private boolean done = false;

    public List<Integer> grayCode(int n) {
        this.n = n;
        for (int i = 0; i < n; i++) len = len << 1;
        vis = new boolean[len];
        ans.add(0);
        vis[0] = true;
        backtrack();
        return ans1;
    }

    private void backtrack() {
        if (done) return;
        if (ans.size() == len && check(ans.get(ans.size() - 1), 0)) {
            ans1 = new ArrayList<>(ans);
            done = true;
            return;
        }
        int before = ans.get(ans.size() - 1);
        for (int i = 0; i < len; i++) {
            if (!vis[i] && check(i, before)) {
                ans.add(i);
                vis[i] = true;
                backtrack();
                vis[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    private boolean check(int num, int before) {
        int diff = num ^ before;
        return ((diff & (diff - 1)) == 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.grayCode(9));
    }

}