## 代码

```java
// class Solution {

//     boolean[] vis;

//     public String[] permutation(String s) {
//         List<String> ans = new ArrayList<>();
//         vis = new boolean[s.length()];
//         char[] tmp = s.toCharArray();
//         Arrays.sort(tmp);
//         backtrack(tmp, new StringBuilder(), ans);
//         return ans.toArray(new String[0]);
//     }

//     private void backtrack(char[] s, StringBuilder current, List<String> ans) {
//         if (s.length == current.length()) {
//             ans.add(current.toString());
//             return;
//         }
//         for (int i = 0; i < s.length; i++) {
//             if (i > 0 && s[i - 1] == s[i] && !vis[i - 1]) continue;
//             if (vis[i]) continue;
//             current.append(s[i]);
//             vis[i] = true;
//             backtrack(s, current, ans);
//             vis[i] = false;
//             current.deleteCharAt(current.length() - 1);
//         }
//     }
// }

class Solution {
    public String[] permutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s.toCharArray(), 0, ans);
        return ans.toArray(new String[0]);
    }

    private void backtrack(char[] s, int idx, List<String> ans) {
        if (idx == s.length) {
            ans.add(String.valueOf(s));
            return;
        }
        Set<Character> vis = new HashSet<>();
        for (int i = idx; i < s.length; i++) {
            if (vis.contains(s[i])) continue;
            swap(s, idx, i);
            backtrack(s, idx + 1, ans);
            swap(s, idx, i);
            vis.add(s[i]);
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
```

## 思路

一种按顺序，另一种不断交换

## 参考

略。