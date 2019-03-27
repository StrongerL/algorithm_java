package leetcode.初级算法.数学;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */

public class M02计数质数 {

    public int countPrimes(int n) {

        boolean[] isPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isPrime[i])
            {
                count++;
                for (int j = 2; j * i < n; j++) {
                    isPrime[j * i] = true;
                }
            }

        }

        return count;

    }

}
