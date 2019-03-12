package leetcode.初级算法.动态规划;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */

public class D01爬楼梯 {

    public int climbStairs(int n) {

        // 递归
        // if (n == 1) return 1;
        // if (n == 2) return 2;
        // return climbStairs(n - 1) + climbStairs(n - 2);


        // 递推
        // if (n == 1) return 1;
        // int[] m = new int[n];
        // m[0] = 1;
        // m[1] = 2;
        // for (int i = 2; i < n; i++) {
        //     m[i] = m[i - 1] + m[i - 2];
        // }
        // return m[n - 1];


        // 递推优化
        int a = 1;
        int b = 1;
        while (n > 0) {
            b = b + a;
            a = b - a;
            n--;
        }

        return a;
    }

}
