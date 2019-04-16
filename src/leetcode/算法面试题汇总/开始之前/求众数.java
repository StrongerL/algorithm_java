package leetcode.算法面试题汇总.开始之前;

import java.util.Arrays;

/**
 * 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */


public class 求众数 {

    public int majorityElement(int[] nums) {

        // 排序
        Arrays.sort(nums);
        return nums[nums.length / 2];

        // 不排序
        // int ans = nums[0];
        // int count = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     if (count == 0) {
        //         count++;
        //         ans = nums[i];
        //     } else if (ans == nums[i]) {
        //         count++;
        //     } else {
        //         count--;
        //     }
        // }
        // return ans;

    }

}
