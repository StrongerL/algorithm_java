import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        while(r < s.length()) {
            while (r < s.length() && (!map.containsKey(chars[r]) || map.get(chars[r]) < l)) {
                map.put(chars[r], r);
                r++;
            }
            ans = Math.max(r - l, ans);
            if (r < s.length()) {
                l = map.get(chars[r]) + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abc"));
    }

}