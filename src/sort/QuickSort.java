package sort;


public class QuickSort implements CustomSort {

    public void sort(int[] nums) {
        //  随机打乱保证其随机性
        SortUtil.shuffle(nums);
//        sort(nums, 0, nums.length - 1);
        sortWithDuplicates(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = partition(nums, lo, hi);
        sort(nums, lo, pivot - 1);
        sort(nums, pivot + 1, hi);
    }

    /**
     * 普通快排，用于重复数字少或者没有重复数字的情况
     */
    private int partition(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= tmp) hi--;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= tmp) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = tmp;
        return lo;
    }

    /**
     * 三向切分的快速排序，适用于重复数字很多的情况
     */
    private static void sortWithDuplicates(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            if (nums[i] < v) {
                SortUtil.swap(nums, lt++, i++);
            } else if (nums[i] > v) {
                SortUtil.swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sortWithDuplicates(nums, lo, lt - 1);
        sortWithDuplicates(nums, gt + 1, hi);
    }

}
