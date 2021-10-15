//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 612 👎 0


import java.util.*;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cntP[p.charAt(i) - 'a']++;
        }
        for (int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            cntS[ch - 'a']++;
            // s 中该元素数量小于 p 中数量，需要继续扩大窗口
            // s 中该元素数量等于 p 中数量，从l处到r都符合要求
            // s 中该元素数量大于 p 中数量，说明遇到了p中没有的字符或者有重复字符，需要缩小窗口
            while (cntS[ch - 'a'] > cntP[ch - 'a']) {
                cntS[s.charAt(l++) - 'a']--;
            }
            if (r - l + 1 == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
