package leetcode.初级算法.设计问题;

import java.util.Random;

/**
 * Shuffle an Array
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */

public class D01ShuffleAnArray {

    private int[] srcNums;
    private int[] nums;

    public D01ShuffleAnArray(int[] nums) {
        this.srcNums = nums.clone();
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return srcNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        int index, tmp;
        for (int i = 0; i < nums.length; i++) {
            index = rand.nextInt(nums.length);
            tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
        return nums;

    }

}
