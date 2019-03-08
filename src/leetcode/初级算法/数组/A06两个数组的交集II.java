package leetcode.初级算法.数组;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A06两个数组的交集II {

    /**
     * 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */

    public int[] intersect(int[] nums1, int[] nums2) {


        // 我的解法
//         List<Integer> result = new LinkedList<>();
//         int p = 0;

//         List<Integer> list = new LinkedList<>();
//         for (int i = 0; i < nums2.length; i++){
//             list.add(nums2[i]);
//         }

//         for (int i = 0; i < nums1.length; i++){

//             boolean flag = false;
//             for (int j = 0; j < list.size(); j++){
//                 if (nums1[i] == list.get(j))
//                 {
//                     flag = true;
//                     list.remove(j);
//                     break;
//                 }
//             }

//             if (flag)
//                 result.add(nums1[i]);

//         }

//         int[] res = new int[result.size()];

//         for (int i = 0; i < res.length; i++){
//             res[i] = result.get(i);
//         }

//         return res;


        // 使用map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++){

            if(map.containsKey(nums1[i])) {
                map.replace(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }

        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                res.add(nums2[i]);
                map.replace(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;

    }

}
