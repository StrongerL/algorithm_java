package leetcode.算法面试题汇总.字符串;

import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

public class 分割回文串 {

    private List<List<String>> ll = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new LinkedList<>());
        return ll;
    }

    // 回溯
    private void backtracking(String s, int index, List l){

        if (index == s.length()) {
            ll.add(new LinkedList<>(l));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (isPalindrome(substring)) {
                l.add(substring);
                backtracking(s, i, l);
                l.remove(l.size() - 1);
            }
        }

    }

    // 判断是否是回文串
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

}
