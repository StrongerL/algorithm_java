package leetcode.初级算法.字符串;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class S02整数反转 {

    public int reverse(int x) {

        if (x == 0)
            return 0;

        // 去掉尾部的0
        String s = x + "";
        int zeros = 0;
        while(s.charAt(s.length() - 1 - zeros) == '0') {
            zeros++;
        }
        s = s.substring(0, s.length() - zeros);

        // 是否是负数
        if (s.startsWith("-"))
            s = "-" + new StringBuffer(s.substring(1)).reverse().toString();
        else
            s = new StringBuffer(s).reverse().toString();

        // 判断是否超范围
        if (Long.parseLong(s) > Math.pow(2, 31) - 1 || Long.parseLong(s) < -Math.pow(2, 31)) {
            return 0;
        }

        return Integer.parseInt(s);
    }

}
