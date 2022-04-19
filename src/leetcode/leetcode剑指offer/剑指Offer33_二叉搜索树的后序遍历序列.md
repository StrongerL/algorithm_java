## 代码

```java
// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] nums, int left, int right) {
        if (left >= right) return true;
        int root = nums[right];
        int mid = left;
        while (nums[mid] < root) mid++;
        for (int i = mid; i < right; i++) {
            if (nums[i] < root) return false;
        }
        return verify(nums, left, mid - 1) && verify(nums, mid, right - 1);
    }

}
```



## 思路

以第一个大于root的值为界，分为左子树，右子树。

如果右子树中有值小于root，说明不是后序遍历。



## 参考

1. https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/