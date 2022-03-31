## 代码

```java
// https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (true) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            swap(i, nums[i], nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```

## 思路

利用哈希的思想，将每一个值都放在和它一样的下标处，放的时候如果发现相等，那么就是一个重复值。

## 参考

1. https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/