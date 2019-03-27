package leetcode.初级算法.其他;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */

public class O05有效的括号 {

    public boolean isValid(String s) {

        Map<Character, Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('[', ']');
        m.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && m.get(stack.peek()) != null && s.charAt(i) == m.get(stack.peek())) {
                stack.pop();
            } else
                stack.push(s.charAt(i));
        }

        return stack.isEmpty();

    }

}
