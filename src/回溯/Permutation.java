package 回溯;

import java.util.Arrays;

public class Permutation {

    private static int count;
    private static int times;

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4};

        System.out.println(perm(nums, 0));

        System.out.println(times);
    }


    private static int perm(int[] nums, int k) {

        times++;

        for (int i = k; i < nums.length; i++) {

            swap(nums, i, k);

            if (k == nums.length - 1) {
                count++;
                System.out.println(Arrays.toString(nums));
            } else {
                perm(nums, k + 1);
            }

            swap(nums, i, k);
        }

        return count;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
