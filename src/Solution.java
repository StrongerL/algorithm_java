import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        if (i != 0) {
            int j = n - 1;
            while (j >= i && nums[j] <= nums[i - 1]) j--;
            swap(nums, i - 1, j);
        }
        for (int k = i; k < (n + i)/2; k++) swap(nums, k, (n - 1) - (k - i));
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}