## 代码

```java
// 快排的核心，将一个数组分为2部分
// 同相双指针
// class Solution {
//     public int[] exchange(int[] nums) {
//         int i = -1;
//         for (int j = i + 1; j < nums.length; j++) {
//             if (nums[j] % 2 == 1) {
//                 swap(nums, ++i, j);
//             }
//         }
//         return nums;
//     }

//     private void swap(int[] nums, int i, int j) {
//         int tmp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = tmp;
//     }
// }

// 异向双指针
class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int tmp = nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[right] % 2 == 0) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] % 2 == 1) left++;
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return nums;
    }
}
```

## 思路

双指针。

## 参考

略。