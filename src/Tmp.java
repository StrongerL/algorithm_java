import java.util.*;

public class Tmp {

    // 测试

    public static void main(String[] args) {

        int[] a = new int[10];
        int[][] b = new int[10][10];

        test(a, b);

        System.out.println(a[0]);
        System.out.println(b[0][0]);
    }


    private static void test(int[] a, int[][] b) {

        a[0] = 1;
        b[0][0] = 1;
    }

}
