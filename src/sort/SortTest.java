package sort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {

        CustomSort customSort = new QuickSort();
        int[] randomArray = SortUtil.getRandomArrayWithDuplicates(20);
        System.out.println(Arrays.toString(randomArray));
        customSort.sort(randomArray);
        System.out.println(Arrays.toString(randomArray));

    }

}
