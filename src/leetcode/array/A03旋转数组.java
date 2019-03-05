package leetcode.array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */

public class A03旋转数组 {

    /**
     * 思路1：
     * 每次移动一位
     * 思路2：
     * 旋转相当于把后一段移到前一段
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        // 我的解法
        // while (k-- > 0)
        // {
        //     int tmp = nums[nums.length - 1];
        //     for (int i = nums.length - 1; i > 0; i--)
        //     {
        //         nums[i] = nums[i - 1];
        //     }
        //     nums[0] = tmp;
        // }


        // 较快的解法
        k = k % nums.length;
        int[] tmp = nums.clone();
        System.arraycopy(tmp, nums.length - k, nums, 0, k);
        System.arraycopy(tmp, 0, nums, k, nums.length - k);
    }

}
