package leetcode.初级算法.字符串;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

public class S04有效的字母异位词 {

    public boolean isAnagram(String s, String t) {

        // 10.36
        // 1. map
//         if (s.length() != t.length())
//             return false;

//         Map<Character, Integer> map = new HashMap<>();

//         for (char o: s.toCharArray()) {
//             if (map.containsKey(o))
//                 map.replace(o, map.get(o) + 1);
//             else
//                 map.put(o, 1);
//         }

//         for (char o: t.toCharArray()) {
//             if (map.containsKey(o) && map.get(o) > 0) {
//                 map.replace(o, map.get(o) - 1);
//             } else {
//                 return false;
//             }
//         }

//         return true;
        // 10.45

        // 2.数组
        // if (s.length() != t.length()) return false;
        // int[] c = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     c[s.charAt(i) - 'a']++;
        //     c[t.charAt(i) - 'a']--;
        // }
        // for (int i: c) {
        //     if (i != 0)
        //         return false;
        // }
        // return true;
        // 10.53


        // 3.api
        if (s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);

    }


}
