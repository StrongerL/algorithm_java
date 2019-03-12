package leetcode.初级算法.排序和搜索;

/**
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */

public class S01合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // 借助临时数组
//         int[] tmp = new int[m + n];

//         int i = 0;
//         int j = 0;
//         int k = 0;
//         while (i < m && j < n) {
//             if (nums1[i] <= nums2[j]) {
//                 tmp[k] = nums1[i];
//                 i++;
//             } else {
//                 tmp[k] = nums2[j];
//                 j++;
//             }
//             k++;
//         }

//         if (i == m) {
//             for (; j < n; j++) {
//                 tmp[k] = nums2[j];
//                 k++;
//             }
//         }

//         if (j == n) {
//             for (; i < m; i++) {
//                 tmp[k] = nums1[i];
//                 k++;
//             }
//         }

//         for (i = 0; i < m + n; i++) {
//             nums1[i] = tmp[i];
//         }


        // 从后往前扫描
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }

}
