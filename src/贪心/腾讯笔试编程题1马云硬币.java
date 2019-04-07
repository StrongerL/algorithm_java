package 贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * NKOJ 3847 马云
 * 问题描述
 *
 * Mr_he 因讨厌马云而彻底放弃网购，他的日常用品都要到商场去购买，而且必须付现金。
 * 但是现 金购买，经常会遇到找零的问题，那么现在请你帮助他解决这样一个问题：
 * 现在 Mr_he 手上有 n 种不同面值的硬币，每种硬币有无限多个。为了方便购物，
 * 他希望带尽量 少的硬币，但是要能组合出 1 到 m 之间的任意值。
 *
 * 输入格式
 * 第一行为两个整数：m 和 n，他们的意义如题目描述。
 * 接下来的 n 行，每行一个整数，第 i+1 行的整数表示第 i 种硬币的面值
 *
 * 输出格式
 * 最少需要携带的硬币数量，如果无解则输出-1。
 *
 * 样例输入
 * 20 4
 * 1
 * 2
 * 5
 * 10
 *
 * 样例输出
 * 5
 *
 * 数据范围
 * 50%的数据：1<=n<=10， 1<=m<=10^3；
 * 100%的数据：1<=n<=100，1<=m<=10^9；
 *
 *
 * 思路：
 * 到i-1的任意值都可以组合给出
 * 那么如果需要给出i
 * 需要从硬币中选择一个满足面值不大于i的硬币即可
 * 为了使硬币个数最少，我们选择一个符合条件且面值最大的硬币（假设面值为s)
 * 这样我们不仅可以组合出i，还可以组合出[1, i-1+s]集合中的任意值
 * 从而更快的逼近m
 *
 */

/*
输入数据
20 4
1
2
5
10
*/

public class 腾讯笔试编程题1马云硬币 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        Arrays.sort(nums);
        if (nums[0] != 1) {
            System.out.println(-1);
            return;
        }

        int sum = 1;
        int count = 1;
        while (sum < m) {
            int i;
            for (i = 0; i < n; i++) {
                if (nums[i] > sum + 1)
                    break;
            }
            sum += nums[i - 1];
            count++;
        }

        System.out.println(count);
    }

}
