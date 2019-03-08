package leetcode.初级算法.字符串;

/**
 * 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class S08报数 {

    public String countAndSay(int n) {

        // 递归
//         if (n == 1)
//             return "1";
//         else {
//             String c = countAndSay(n - 1);
//             char[] cc = c.toCharArray();
//             String s = "";
//             int count = 1;
//             for (int i = 0; i < cc.length; i++) {
//                 if (i == cc.length - 1)
//                     return s + count + cc[i];

//                 if (cc[i] == cc[i + 1])
//                     count++;
//                 else {
//                     s = s + count + cc[i];
//                     count = 1;
//                 }
//             }
//             return s;
//         }
        // 17.24

        // 18.24
        // 递推
        String res = "1";
        for (int k = 1; k < n; k++) {
            String s = "";
            int count = 1;
            for (int i = 0; i < res.length(); i++) {
                if (i != res.length() - 1 && res.charAt(i) == res.charAt(i + 1)) {
                    count++;
                } else {
                    s = s + count + res.charAt(i);
                    count = 1;
                }
            }
            res = s;
        }

        return res;
    }

}
