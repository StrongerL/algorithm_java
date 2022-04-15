## 代码

```java
class Solution {
    public boolean isNumber(String s) {
        if (s.charAt(0) == 'e' || s.charAt(0) == 'E') return false;
        if (s.trim().endsWith("e") || s.trim().endsWith("E")) return false;
        String[] arr = s.trim().toUpperCase().split("E");
        if (arr.length < 1) return false;
        if (arr.length == 1) {
            return isFloat(arr[0]) || isInt(arr[0]);
        }
        if (arr.length == 2) return (isFloat(arr[0]) || isInt(arr[0])) && isInt(arr[1]);
        return false;
    }

    private boolean isFloat(String s) {
        if (s == null || s.length() < 2) return false;
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() < 3) return false;
            start++;
        }
        int dotIdx = s.indexOf('.');
        for (int i = start; i < s.length(); i++) {
            if (i == dotIdx) continue;
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    private boolean isInt(String s) {
        if (s == null || s.length() < 1) return false;
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() < 2) return false;
            start++;
        }
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

}
```

## 思路

模拟。

## 参考

略。