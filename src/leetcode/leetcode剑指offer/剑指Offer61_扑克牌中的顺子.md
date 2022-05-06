## 代码

```java
// https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
// 排序
// class Solution {
//     public boolean isStraight(int[] nums) {
//         Arrays.sort(nums);
//         int zeroCount = 0;
//         int i = 0;
//         while (nums[i] == 0) {
//             zeroCount++;
//             i++;
//         }
//         while (i < 4) {
//             if (nums[i + 1] == nums[i]) return false;
//             zeroCount -= (nums[i + 1] - nums[i] - 1);
//             i++;
//         }
//         return zeroCount >= 0;
//     }
// }

// 判断最大值和最小值的差
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 0) continue;
            if (set.contains(num)) return false;
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        return max - min < 5;
    }
}
```

## 思路

比较最大值和最小值的差。

## 参考

1. https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/