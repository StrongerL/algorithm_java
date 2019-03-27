package sort;

import java.util.Arrays;
import java.util.Random;

public class Sort2 {

    public static void main(String[] args) {

        int[] nums = getRandomArray(20);
        System.out.println(Arrays.toString(nums));
        long start = System.currentTimeMillis();

        // 冒泡排序
//        bubbleSort(nums);
        // 快速排序
//        quickSort(nums);

        // 直接插入排序
//        insertSort(nums);
        // 希尔排序
//        shellSort(nums);

        // 简单选择排序
//        selectSort(nums);
        // 堆排序
//        heapSort(nums);

        // 归并排序
        mergeSort(nums);

        long time = System.currentTimeMillis() - start;
        System.out.println("耗时：" + time + "ms");
        System.out.println(Arrays.toString(nums));

    }


    // 交换

    public static void bubbleSort(int[] nums) {

        int j;
        boolean flag;
        for (int i = nums.length - 1; i > 0; i--) {
            j = 0;
            flag = true;
            while (j < i) {
                if (nums[j] > nums[j + 1]) {
                    exchange(nums, j, j + 1);
                    flag = false;
                }
                j++;
            }
            if (flag) break;
        }

    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }


    // 插入

    public static void insertSort(int[] nums) {

        int j, cur;
        for (int i = 1; i < nums.length; i++) {
            j = i - 1;
            cur = nums[i];
            while (j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }

    }

    public static void shellSort(int[] nums) {

        int d = nums.length / 2;
        while (d >= 1) {
            int j, cur;
            for (int i = d; i < nums.length; i++) {
                j = i - d;
                cur = nums[i];
                while (j >= 0 && nums[j] > cur) {
                    nums[j + d] = nums[j];
                    j -= d;
                }
                nums[j + d] = cur;
            }
            d /= 2;
        }

    }


    // 选择

    public static void selectSort(int[] nums) {

        int j, max;
        for (int i = nums.length - 1; i >= 0; i--) {
            max = i;
            j = 0;
            while (j < i) {
                if (nums[j] > nums[max])
                    max = j;
                j++;
            }
            exchange(nums, i, max);
        }

    }

    public static void heapSort(int[] nums) {

        buildHeap(nums);
        int size = nums.length;
        while (size > 1) {
            exchange(nums, 0, size - 1);
            heapify(nums, --size, 0);
        }

    }
    private static void buildHeap(int[] nums) {

        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }

    }
    private static void heapify(int[] nums, int size, int root) {

        int left = 2 * root + 1;
        int right = left + 1;
        int max = root;
        if (left < size && nums[left] > nums[max])
            max = left;
        if (right < size && nums[right] > nums[max])
            max = right;
        if (root != max) {
            exchange(nums, root, max);
            heapify(nums, size, max);
        }

    }


    // 归并

    public static void mergeSort(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

    }
    private static void mergeSort(int[] nums, int left, int right) {

        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private static void merge(int[] nums, int leftStart, int leftEnd, int rightEnd) {

        int rightStart = leftEnd + 1;
        int[] tmp = new int[rightEnd - leftStart + 1];
        int l = leftStart;
        int r = rightStart;
        int p = 0;
        while (l <= leftEnd && r <= rightEnd) {
            if (nums[l] <= nums[r])
                tmp[p++] = nums[l++];
            else
                tmp[p++] = nums[r++];
        }
        while (l <= leftEnd) tmp[p++] = nums[l++];
        while (r <= rightEnd) tmp[p++] = nums[r++];

        p--;
        while (p >= 0) nums[rightEnd--] = tmp[p--];
    }


    private static void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int[] getRandomArray(int n) {
        int randomly[] = new int[n];
        Random random = new Random(10);
        int temp;
        int tempIndex;
        for (int i = 0; i < n; i++) {
            randomly[i] = i;
        }
        for (int i = 0; i < n; i++) {
            tempIndex = random.nextInt(n);
            temp = randomly[i];
            randomly[i] = randomly[tempIndex];
            randomly[tempIndex] = temp;
        }
        return randomly;
    }

}
