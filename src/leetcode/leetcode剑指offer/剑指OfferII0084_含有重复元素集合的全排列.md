# 代码

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> cur = new ArrayList<>(nums.length);
        for (int num : nums) cur.add(num);
        dfs(cur, 0);
        return ans;
    }

    void dfs(List<Integer> cur, int idx) {
        if (cur.size() == idx) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < cur.size(); i++) {
            if (set.contains(cur.get(i))) continue;
            set.add(cur.get(i));
            Collections.swap(cur, i, idx);
            dfs(cur, idx + 1);
            Collections.swap(cur, i, idx);
        }
    }
}
```

# 思路

回溯

# 参考

1. 无。