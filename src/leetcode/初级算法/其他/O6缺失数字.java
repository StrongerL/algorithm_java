package leetcode.初级算法.其他;

/**
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */

public class O6缺失数字 {

    public int missingNumber(int[] nums) {

        // Arrays.sort(nums);
        // // 缺失0
        // if (nums[0] != 0) return 0;
        // // 缺失中间的数
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] + 1 != nums[i + 1])
        //         return nums[i] + 1;
        // }
        // // 缺失最后一个数
        // return nums.length;



        // 运用等差数列
        int n = nums.length;
        int res = n * (n + 1) / 2;
        for (int o : nums)
            res -= o;
        return res;

    }

}
