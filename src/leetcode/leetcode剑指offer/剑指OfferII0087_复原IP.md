# 代码

```java
class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, new StringBuilder());
        return ans;
    }

    void dfs(String s, int idx, int seg, StringBuilder cur) {
        if (idx == s.length()) {
            if (seg == 4) ans.add(cur.toString().substring(0, cur.length() - 1));
            return;
        }
        if (seg >= 4) return;
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            String num = s.substring(idx, i + 1);
            if (!check(num)) break;
            cur.append(num).append(".");
            dfs(s, i + 1, seg + 1, cur);
            cur.delete(cur.length() - (i - idx + 1) - 1, cur.length());
        }
    }

    boolean check(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        if (s.length() > 3) return false;
        return Integer.parseInt(s) < 256;
    }
}
```

# 思路

回溯

# 参考

1. 无。