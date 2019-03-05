package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */

public class A04存在重复 {

    /**
     * 思路1：
     * 两重循环
     * 思路2：
     * 使用set
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {


        // 解法1
//         for (int i = 0; i < nums.length - 1; i++)
//         {
//             for (int j = i + 1; j < nums.length; j++)
//             {
//                 if (nums[i] == nums[j])
//                     return true;
//             }
//         }

//         return false;

        // 解法2
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++)
        {
            if (!set.add(nums[i]))
                return true;
        }
        return false;

    }

}
