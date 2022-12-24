# 代码

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return ans;
    }

    void dfs(int[] nums, List<Integer> cur, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        dfs(nums, cur, idx + 1);
        cur.add(nums[idx]);
        dfs(nums, cur, idx + 1);
        cur.remove(cur.size() - 1);
    }
}
```

# 思路

回溯

# 参考

1. 无。