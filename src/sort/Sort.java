package sort;

import java.util.*;

public class Sort {

    public static void main(String[] args)
    {
        int[] randomArray = getRandomArray(20);
        System.out.println(Arrays.toString(randomArray));

        // 直接插入排序
//        straightInsertSort(randomArray);

        // 希尔排序
        shellSort(randomArray);

        System.out.println(Arrays.toString(randomArray));

        test();

    }

    public static void test(){

        Set<Character> strings = new HashSet<>();
        strings.add('a');
        System.out.println(strings.add('b'));
        strings.clear();
        System.out.println('a' == 'a');



    }



    /**
     * 直接插入排序
     * 空间复杂度 o(1)
     * 时间复杂度
     * 最好情况：排好序，o(n)
     * 最坏情况：逆序，o(n^2)
     * 平均情况：o(n^2)
     * 稳定
     *
     * 数据基本有序时更加高效
     * @param nums
     */
    public static void straightInsertSort(int[] nums) {

        // 解法1
//        for (int i = 1; i < nums.length; i++)
//        {
//            int tmp = nums[i];
//            for (int j = i - 1; j >= 0; j--)
//            {
//                if (tmp > nums[j]){
//                    nums[j + 1] = nums[j];
//                    // 如果没有加上如下判断，则比第一个数小的数都会被第一个数替代
//                    if (j == 0)
//                        nums[j] = tmp;
//                } else {
//                    nums[j + 1] = tmp;
//                    break;
//                }
//            }
//        }

        // 解法2
        int tmp, j;
        for (int i = 1; i < nums.length; i++){
            tmp = nums[i];
            j = i - 1;
            // tmp > nums[j] 为降序，< 为升序
            while (j > -1 && tmp < nums[j]){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }

    }


    /**
     * 希尔排序
     * 空间复杂度o(1)
     * 时间复杂度较为复杂，与增量序列有关
     * o(n^1.25）～o（1.6n^1.25）
     * 不稳定
     * @param nums
     */
    public static void shellSort(int[] nums){

        // 这是最初的增量序列，后来又提出许多其他如2^k - 1，会得到更低的时间复杂度
        int d = nums.length / 2;

        while(d >= 1){
            int j, tmp;
            // 对每组进行直接插入排序，轮流进行
            for (int i = d; i < nums.length; i++){ // 这个循环相当于循环操作分组+循环每个分组中的元素
                tmp = nums[i];
                j = i - d;
                while(j > -1 && tmp < nums[j]) {
                    nums[j + d] = nums[j];
                    j = j - d;
                }
                nums[j + d] = tmp;
            }

            d /= 2;
        }
    }



    public static int[] getRandomArray(int n) {
        int randomly[] = new int[n];
        Random random = new Random();
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
