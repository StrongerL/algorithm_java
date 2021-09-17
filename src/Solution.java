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
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new LinkedList<>();
        int n = s.length(), window = p.length();
        if (n < window) {
            return ans;
        }

        Map<Character, Integer> map = new HashMap<>();
        int needCnt = 0, i = 0, j = 0;
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            needCnt++;
        }
        final Map<Character, Integer> ORIGIN_MAP = new HashMap<>(map);
        final int ORIGIN_NEED_CNT = needCnt;


        while (i <= n - window && j < n) {
            while (j - i + 1 <= window && j < n) {
                char ch = s.charAt(j++);
                if (map.getOrDefault(ch, -1) > 0) {
                    map.put(ch, map.get(ch) - 1);
                    needCnt--;
                } else {
                    i = j;
                    needCnt = ORIGIN_NEED_CNT;
                    map.putAll(ORIGIN_MAP);
                }
            }

            if (j > n || i >= n) {
                return ans;
            }

            if (needCnt == 0) {
                ans.add(i);
            }
            char ch = s.charAt(i++);
            map.put(ch, map.get(ch) + 1);

        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
