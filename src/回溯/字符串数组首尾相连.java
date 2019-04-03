package 回溯;

import java.util.Arrays;
/**
 * 给定字符串数组{"gj","jl","dg","ad","gg"}
 * 是首尾相连的[ad, dg, gg, gj, jl]
 * @author yanjie
 *
 */
public class 字符串数组首尾相连 {

    private static int count;

    public static void main(String[] args) {

        String[] arr = {"gj", "jl", "dg", "ad", "gg", "ggg", "gggg"};
        System.out.println(fun(arr, 0));
    }


    private static int fun(String[] arr, int k) {

        for (int i = k; i < arr.length; i++) {
            if (k == 0 || judge(arr[k - 1], arr[i])) {
                swap(arr, k, i);
                if (k == arr.length - 1){
                    System.out.println(Arrays.toString(arr));
                    count++;
                } else {
                    fun(arr, k + 1);
                }
                swap(arr, k, i);
            }
        }

        return count;
    }

    private static boolean judge(String left, String right) {
        return left.charAt(left.length() - 1) == right.charAt(0);
    }

    private static void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}