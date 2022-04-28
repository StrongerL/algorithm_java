## 代码

```java
// https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
class Solution {
    int ans = 0;
    int[] tmp;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right) {
        if (left >= right) return;
        int p1 = left, p2 = mid + 1, p = left;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                tmp[p++] = nums[p1++];
            } else {
                tmp[p++] = nums[p2++];
                ans += mid - p1 + 1;
            }
        }
        while (p1 <= mid) tmp[p++] = nums[p1++];
        while (p2 <= right) tmp[p++] = nums[p2++];
        for (int i = left; i <= right; i++) nums[i] = tmp[i];
    }

}
```

## 思路

归并排序。

## 参考

1. https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/