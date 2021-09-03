//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1235 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    测试用例:"2[2[y]pq4[2[jk]e1[f]]]ef"
//    测试结果:"yypqjkjkefefefefpqjkjkefefefefef"
//    期望结果:"yypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.decodeString("2[2[y]pq4[2[jk]e1[f]]]ef").equals("yypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
        System.out.println("yypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
    }


    public String decodeString(String s) {

        char[] chars = s.toCharArray();
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> stringStack = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(chars[i])) {
                int len = getNumberLength(chars, i);
                int num = Integer.parseInt(String.valueOf(chars, i, len));
                numStack.push(num);
                if (numStack.size() > stringStack.size() + 1) {
                    stringStack.push(new StringBuilder());
                }
                i += len - 1;
            } else if (Character.isLetter(chars[i])) {
                int len = getStringLength(chars, i);
                String currentString = String.valueOf(chars, i, len);
                if (numStack.isEmpty()) {
                    ans.append(currentString);
                } else if (numStack.size() == stringStack.size()) {
                    stringStack.peek().append(currentString);
                } else {
                    stringStack.push(new StringBuilder(currentString));
                }
                i += len - 1;
            } else if (chars[i] == ']') {
                String currentString = stringStack.pop().toString();
                int count = numStack.pop();
                StringBuilder sb = stringStack.isEmpty() ? ans : stringStack.peek();
                for (int j = 0; j < count; j++) {
                    sb.append(currentString);
                }
            }
            i++;
        }

        return ans.toString();
    }

    private int getNumberLength(char[] chars, int i) {
        int len = 0;
        while (i < chars.length && Character.isDigit(chars[i])) {
            len++;
            i++;
        }
        return len;
    }

    private int getStringLength(char[] chars, int i) {
        int len = 0;
        while (i < chars.length && Character.isLetter(chars[i])) {
            len++;
            i++;
        }
        return len;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
