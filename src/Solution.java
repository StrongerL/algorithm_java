import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("a", "aa"));

    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        int needCnt = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (need.containsKey(ch)) {
                need.put(ch, need.get(ch) + 1);
            } else {
                need.put(ch, 1);
            }
            needCnt++;
        }

        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        String minStr = "";

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (need.get(ch) == null) {
                need.put(ch, -1);
            } else {
                if (need.get(ch) > 0) {
                    needCnt--;
                }
                need.put(ch, need.get(ch) - 1);
            }
            if (needCnt <= 0) {
                while (i <= j && needCnt <= 0) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        minStr = s.substring(i, j + 1);
                    }
                    char iChar = s.charAt(i);
                    need.put(iChar, need.get(iChar) + 1);
                    if (need.get(iChar) > 0) {
                        needCnt++;
                    }
                    i++;
                }
            }

            j++;
        }

        return minStr;
    }
}