package leetcode.字符串;

/**
 * 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */

public class S05验证回文字符串 {

    public boolean isPalindrome(String s) {

        if (s.length() == 0) return true;

        s = s.toUpperCase();

        int head = 0;
        int tail = s.length() - 1;
        while (head < tail){
            while (head < s.length() && !Character.isLetterOrDigit(s.charAt(head))) head++;
            while (tail > -1 && !Character.isLetterOrDigit(s.charAt(tail))) tail--;
            if (head >= tail) return true;
            if (s.charAt(head) != s.charAt(tail)) return false;
            head++;
            tail--;
        }

        return true;
    }

}
