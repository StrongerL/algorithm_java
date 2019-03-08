package leetcode.初级算法.字符串;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */

public class S09最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        String s = "";
        char[] c = strs[0].toCharArray();
        for (int i = 0; i < c.length; i++) {
            s += c[i];
            for (String o: strs) {
                if (!o.startsWith(s)) {
                    return s.substring(0, s.length() - 1);
                }
            }
        }

        return s;

    }

}
