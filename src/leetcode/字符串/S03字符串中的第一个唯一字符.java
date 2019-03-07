package leetcode.字符串;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */

public class S03字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        // 9.57
        // 使用map
//         Map<Character, Integer> map = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {
//             char a = s.charAt(i);
//             if (map.containsKey(a))
//                 map.replace(a, map.get(a) + 1);
//             else
//                 map.put(a, 1);
//         }

//         for (int i = 0; i < s.length(); i++) {
//             if (map.get(s.charAt(i)) == 1)
//                 return i;
//         }

//         return -1;
        // 10.18

        // lastIndexOf()1
        // for (int i = 0; i < s.length(); i++) {
        //     char a = s.charAt(i);
        //     if (s.indexOf(a) == s.lastIndexOf(a)) {
        //         return i;
        //     }
        // }
        // return -1;

        // lastIndexOf()2
        int res = -1;
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && s.lastIndexOf(i) == index) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
        // 10.36

    }

}
