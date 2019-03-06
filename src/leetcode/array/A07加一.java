package leetcode.array;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class A07加一 {

    /**
     * 递归和递推
     * @param digits
     * @return
     */

    public int[] plusOne(int[] digits) {

        // 递归
        // return plus(digits, digits.length);

        // 递推1
        int len = digits.length;

        digits[len - 1]++;

        if (digits[len - 1] > 9) {
            int j = len - 1;
            while(j > 0 && digits[j] > 9) {
                digits[j] -=10;
                j--;
                digits[j]++;
            }
        }

        if (digits[0] > 9) {
            int[] res = new int[len + 1];
            res[0] = 1;
            res[1] = 0;
            System.arraycopy(digits, 1, res, 2, len - 1);
            digits = res;
        }

        return digits;

    }


    public int[] plus(int[] digits, int length) {

        if (digits[length - 1] != 9){
            digits[length - 1] = digits[length - 1] + 1;
            return digits;
        } else {
            digits[length - 1] = 0;
            if (length != 1)
                return plus(digits, length - 1);
            else {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                for (int i = 1; i < digits.length; i++) {
                    res[i] = digits[i - 1];
                }
                return res;
            }
        }
    }

}
