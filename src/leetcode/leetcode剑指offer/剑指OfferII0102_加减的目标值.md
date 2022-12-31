# 代码

```java
class Solution {
    
    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0);
        return ans;
    }

    void dfs(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            if (target == 0) ans++;
            return;
        }
        dfs(nums, target - nums[idx], idx + 1);
        dfs(nums, target + nums[idx], idx + 1);
    }

}
```

# 思路

回溯

# 参考

1. 无。