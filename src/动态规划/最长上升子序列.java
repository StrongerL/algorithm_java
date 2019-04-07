package 动态规划;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 最长上升子序列 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 7, 3, 5, 9, 4, 8};

        List l = getLIS(nums);

        System.out.println(Arrays.toString(l.toArray()));

    }

    private static List<Integer> getLIS(int[] nums) {

        List<Integer> l = new LinkedList<>();

        int n = nums.length;
        int[] res = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
            pre[i] = -1;
        }

        // 得出最长上升子序列长度
        int max;
        for (int i = 1; i < n; i++) {
            max = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && res[j] > max) {
                    max = res[j];
                    pre[i] = j;
                }
            }
            res[i] = max + 1;
        }
        int indexOfMaxValue = 1;
        for (int i = 0; i < n; i++) {
            if (res[i] > res[indexOfMaxValue])
                indexOfMaxValue = i;
        }

        // 得出一个最长上升子序列
        int i = indexOfMaxValue;
        while (i >= 0) {
            l.add(0, nums[i]);
            i = pre[i];
        }

        return l;
    }


}
