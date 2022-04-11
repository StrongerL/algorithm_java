## 代码

```java
// https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/1016816
// 不考虑大数
// class Solution {
//     public int[] printNumbers(int n) {
//         int len = power(10, n) - 1;
//         int[] ans = new int[len];
//         for (int i = 0; i < len; i++) {
//             ans[i] = i + 1;
//         }
//         return ans;
//     }

//     public int power(int num, int n) {
//         int ans = 1;
//         while (n > 0) {
//             if (n % 2 == 1) {
//                 ans *= num;
//             }
//             num *= num;
//             n /= 2;
//         }
//         return ans;
//     }
// }

// 考虑大数
class Solution {

    char[] nums = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            dfs(list, new StringBuilder(""), 0, i);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(list.get(i));
        }
        return ans;
    }

    public void dfs(List<String> list, StringBuilder current, int idx, int n) {
        if (idx == n) {
            list.add(current.toString());
            return;
        }
        int start = (idx == 0) ? 1 : 0;
        for (int i = start; i < 10; i++) {
            char c = nums[i];
            current.append(c);
            dfs(list, current, idx + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
```

## 思路

dfs，注意要避免前置0。

## 参考

1. https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/1016816