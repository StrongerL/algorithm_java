package sort;

import java.util.Random;

public class SortUtil {

    private static Random r;

    public static void shuffle(int[] nums) {
        Random rnd = r;
        if (rnd == null)
            r = rnd = new Random();
        shuffle(nums, rnd);
    }

    public static void shuffle(int[] nums, Random rnd) {
        int n = nums.length;
        for (int i = n; i > 1; i--) {
            swap(nums, i - 1, rnd.nextInt(i));
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int[] getRandomArray(int n) {
        int[] randomly = new int[n];
        for (int i = 0; i < n; i++) {
            randomly[i] = i;
        }
        shuffle(randomly);
        return randomly;
    }

    public static int[] getRandomArray(int n, Random rnd) {
        int[] randomly = new int[n];
        for (int i = 0; i < n; i++) {
            randomly[i] = i;
        }
        shuffle(randomly, rnd);
        return randomly;
    }

    public static int[] getRandomArrayWithDuplicates(int n) {
        return getRandomArrayWithDuplicates(n, new Random());
    }

    public static int[] getRandomArrayWithDuplicates(int n, Random rnd) {
        int[] randomly = new int[n];
        for (int i = 0; i < n; i++) {
            randomly[i] = rnd.nextInt(n);
        }
        return randomly;
    }

}
