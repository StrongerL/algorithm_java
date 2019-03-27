package leetcode.初级算法.其他;

import java.util.LinkedList;
import java.util.List;

/**
 * 帕斯卡三角形
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class O4帕斯卡三角形 {

    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0) return new LinkedList<>();

        List<List<Integer>> ll = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        l.add(1);
        ll.add(l);

        for (int i = 1; i < numRows; i++) {
            l = new LinkedList<>();
            l.add(1);
            int j = 0;
            List<Integer> pre = ll.get(i - 1);
            while (j + 1 < pre.size()) {
                l.add(pre.get(j) + pre.get(j + 1));
                j++;
            }
            l.add(1);
            ll.add(l);
        }

        return ll;
    }

}
