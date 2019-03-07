package leetcode.数组;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

public class A05只出现一次的数字 {

    /**
     * 思路1：
     * 先排序后查找
     * 思路2：
     * 异或两次归零
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        // 我的解法
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length; i = i + 2)
//         {
//             if (i == nums.length - 1 || nums[i] != nums[i + 1])
//                 return nums[i];
//         }

//         return -1;


        // 使用异或
        int single = 0;
        for (int i = 0; i < nums.length; i++)
        {
            single ^= nums[i];
        }
        return single;

    }

}
