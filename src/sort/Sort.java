//package sort;
//
//import java.util.*;
//
//public class Sort {
//
//    public static void main(String[] args)
//    {
//        int[] nums = getRandomArray(20);
//        System.out.println(Arrays.toString(nums));
//        long start = System.currentTimeMillis();
//
//        /*
//         * 比较类排序
//         */
//
//        // 冒泡排序
////        bubbleSort(nums);
//        // 快速排序
////        quickSort(nums);
//
//        // 直接插入排序
////        straightInsertSort(nums);
//        // 希尔排序
////        shellSort(nums);
//
//        // 简单选择排序
////        selectSort(nums);
//        // 锦标赛排序（树形选择排序）还没写实现
////        tournamentSort(nums);
//        // 堆排序
////        heapSort(nums);
//
//        // 归并排序
//        mergeSort(nums);
//
//
//        /*
//         * 非比较类排序
//         */
//
//        // 基数排序...还未写实现
////        radixSort(nums);
//        // 计数排序...还未写实现
////        countSort(nums);
//        // 桶排序...还未写实现
////        bucketSort(nums);
//
//
//
//        long time = System.currentTimeMillis() - start;
//        System.out.println("耗时：" + time + "ms");
//        System.out.println(Arrays.toString(nums));
//
//    }
//
//
//    /**
//     * 冒泡排序
//     * 空间复杂度
//     *      o(1)
//     * 时间复杂度
//     *      最好：o(n)
//     *      最坏：o(n^2)
//     *      平均：o(n^2)
//     * 稳定
//     * @param nums
//     */
//    public static void bubbleSort(int[] nums) {
//
//        int j;
//        boolean flag; // 标记一轮是否交换元素
//        for (int i = nums.length - 1; i > 0; i--) {
//            j = 0;
//            flag = true;
//            while (j < i) {
//                if (nums[j] > nums[j + 1]) {
//                    exchange(nums, j, j + 1);
//                    flag = false;
//                }
//                j++;
//            }
//            // 如果此轮未交换元素，则已经排好序
//            if (flag) break;
//        }
//    }
//
//
//    /**
//     * 快速排序
//     * 空间复杂度
//     *      o( log(n) )，因为递归需要栈
//     * 时间复杂度
//     *      最好：
//     *      最坏：
//     *      平均：o( n * log(n) )
//     * 不稳定
//     * @param nums
//     */
//    public static void quickSort(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
//    }
//    private static void quickSort(int[] nums, int low, int high) {
//        if (low > high) return;
//        int pivot = partition(nums, low, high);
//        quickSort(nums, low, pivot - 1);
//        quickSort(nums, pivot + 1, high);
//    }
//    private static int partition(int[] nums, int low, int high) {
//        int pivot = nums[low];
//        while (low < high) {
//            while (low < high && nums[high] > pivot) high--;
//            nums[low] = nums[high];
//            while (low < high && nums[low] < pivot) low++;
//            nums[high] = nums[low];
//        }
//        nums[low] = pivot;
//        return low;
//    }
//
//
//    /**
//     * 直接插入排序
//     * 空间复杂度
//     *      o(1)
//     * 时间复杂度
//     *      最好情况：排好序，o(n)
//     *      最坏情况：逆序，o(n^2)
//     *      平均情况：o(n^2)
//     * 稳定
//     *
//     * 数据基本有序时更加高效
//     * @param nums
//     */
//    public static void straightInsertSort(int[] nums) {
//
//        int tmp, j;
//        for (int i = 1; i < nums.length; i++){
//            tmp = nums[i];
//            j = i - 1;
//            // tmp > nums[j] 为降序，< 为升序
//            while (j > -1 && tmp < nums[j]){
//                nums[j + 1] = nums[j];
//                j--;
//            }
//            nums[j + 1] = tmp;
//        }
//
//    }
//
//
//    /**
//     * 希尔排序
//     * 空间复杂度
//     *      o(1)
//     * 时间复杂度
//     *      较为复杂，与增量序列有关
//     *      o(n^1.25）～o（1.6n^1.25）
//     * 不稳定
//     * @param nums
//     */
//    public static void shellSort(int[] nums){
//
////        // 这是最初的增量序列，后来又提出许多其他如2^k - 1，会得到更低的时间复杂度
//        int d = nums.length / 2;
//
//        while(d >= 1){
//            int j, tmp;
//            // 对每组进行直接插入排序，轮流进行
//            for (int i = d; i < nums.length; i++){ // 这个循环相当于循环操作分组+循环每个分组中的元素
//                tmp = nums[i];
//                j = i - d;
//                while(j > -1 && tmp < nums[j]) {
//                    nums[j + d] = nums[j];
//                    j = j - d;
//                }
//                nums[j + d] = tmp;
//            }
//
//            d /= 2;
//        }
//
//    }
//
//
//    /**
//     * 简单选择排序
//     * 空间复杂度
//     *      o(1)
//     * 时间复杂度
//     *      最好：o(n^2)
//     *      最坏：o(n^2)
//     *      平均：o(n^2)
//     * 不稳定[8, 5, 8, 7]
//     * @param nums
//     */
//    public static void selectSort(int[] nums) {
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < nums[min]) {
//                    min = j;
//                }
//            }
//            exchange(nums, min, i);
//        }
//    }
//
//
//    /**
//     * 锦标赛排序（树形选择排序）
//     * 空间复杂度
//     *      o(n)
//     * 时间复杂度
//     *      最好：
//     *      最坏：
//     *      平均：o( n * log(n) )
//     * 稳定（事先约定值相等，左子树胜出）
//     * @param nums
//     */
//    public static void tournamentSort(int[] nums) {
//        // todo
//    }
//
//
//    /**
//     * 堆排序
//     * 空间复杂度
//     *      o(1)
//     * 时间复杂度
//     *      最好：o( n * log(n) )
//     *      最坏：o( n * log(n) )
//     *      平均：o( n * log(n) )
//     * 不稳定
//     * @param nums
//     */
//    public static void heapSort(int[] nums) {
//        buildHeap(nums);
//        int size = nums.length;
//        while (size > 1){
//            exchange(nums, 0, size - 1);
//            heapify(nums, --size, 0);
//        }
//    }
//    // 建堆
//    private static void buildHeap(int[] nums) {
//        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
//            heapify(nums, nums.length, i);
//        }
//    }
//    // 堆化
//    private static void heapify(int[] nums, int size, int root) {
//        int largest = root;
//        int left = root * 2 + 1;
//        int right = left + 1;
//        if (left < size && nums[largest] < nums[left])
//            largest = left;
//        if (right < size && nums[largest] < nums[right])
//            largest = right;
//        if (largest != root) {
//            exchange(nums, root, largest);
//            heapify(nums, size, largest);
//        }
//
//    }
//
//
//    /**
//     * 归并排序
//     * 空间复杂度
//     *      o(n)
//     * 时间复杂度
//     *      最好：o(n)
//     *      最坏：o(n)
//     *      平均：o(n)
//     * 稳定
//     * @param nums
//     */
//    public static void mergeSort(int[] nums) {
//        MSort(nums, 0, nums.length - 1);
//    }
//    private static void MSort(int[] nums, int left, int right) {
//        if (left >= right) return;
//        int mid = left + (right - left) / 2;
//        MSort(nums, left, mid);
//        MSort(nums, mid + 1, right);
//        merge(nums, left, mid + 1, right);
//    }
//    private static void merge(int[] nums, int p1, int p2, int end) {
//        int[] tmp = new int[end - p1 + 1];
//        int end1 = p2 - 1;
//        int i;
//
//        for (i = 0; p1 <= end1 && p2 <= end; i++) {
//            if (nums[p1] <= nums[p2])
//                tmp[i] = nums[p1++];
//            else
//                tmp[i] = nums[p2++];
//        }
//        while (p1 <= end1) tmp[i++] = nums[p1++];
//        while (p2 <= end) tmp[i++] = nums[p2++];
//
//        i--;
//        while (i >= 0) nums[end--] = tmp[i--];
//
//    }
//
//
//    /**
//     * 基数排序
//     * @param nums
//     */
//    public static void radixSort(int[] nums) {}
//
//
//    /**
//     * 计数排序
//     * @param nums
//     */
//    public static void countSort(int[] nums) {}
//
//
//    /**
//     * 桶排序
//     * @param nums
//     */
//    public static void bucketSort(int[] nums) {}
//
//
//    /**
//     * 交换位置
//     * @param nums
//     * @param i
//     * @param j
//     */
//    private static void exchange(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//
//
//    /**
//     * 获取大小为n的随机数组，不出现重复数字
//     * @param n
//     * @return
//     */
//    public static int[] getRandomArray(int n) {
//        int randomly[] = new int[n];
//        Random random = new Random(10);
//        int temp;
//        int tempIndex;
//        for (int i = 0; i < n; i++) {
//            randomly[i] = i;
//        }
//        for (int i = 0; i < n; i++) {
//            tempIndex = random.nextInt(n);
//            temp = randomly[i];
//            randomly[i] = randomly[tempIndex];
//            randomly[tempIndex] = temp;
//        }
//        return randomly;
//    }
//
//}
