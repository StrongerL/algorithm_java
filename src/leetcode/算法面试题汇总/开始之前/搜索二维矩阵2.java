package leetcode.算法面试题汇总.开始之前;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */

public class 搜索二维矩阵2 {


    public boolean searchMatrix(int[][] matrix, int target) {


        // 二分

//         if (matrix.length == 0 || matrix[0].length == 0)
//             return false;

//         int i = 0;
//         int n = matrix[0].length - 1;
//         int left, right, mid;
//         while (i < matrix.length && matrix[i][0] <= target) {
//             left = 0;
//             right = n;
//             while (left <= right) {

//                 mid = left + (right - left) / 2;
//                 if (matrix[i][mid] == target)
//                     return true;
//                 else if (matrix[i][mid] > target) {
//                     right = mid - 1;
//                 } else {
//                     left = mid + 1;
//                 }
//              }
//             i++;
//         }
//         return false;
//     }

        // 利用这个矩阵的特性
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j > -1) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;


    }

}
