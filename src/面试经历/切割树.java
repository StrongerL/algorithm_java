package 面试经历;

import java.util.*;

/**
 * 美团点评 2019春招 后台开发方向在线考试
 * 编程题 | 30.0分2/2
 * 切割树
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给你一棵含有n个结点的树,编号为0…n-1，这n个结点都被染成了黑色或白色，显然，对于一棵树而言，我们每去掉一条边，
 * 就能把树分成两部分。现在要求你把这棵树切开，使得每一个连通块内只有一个白色结点，问共有多少种切开的方式满足以上条件，
 * 如果被删除的边集不同，我们则认为两种方式不同，反之认为相同。
 *
 * 请输出方案数对1000000007取模的结果。
 *
 * 参考输入：
 *
 * 10
 *
 * 0 0 1 2 0 5 1 2 3
 *
 * 1 0 0 1 0 0 1 1 0 1
 *
 *
 *
 * 此时共有三种切割方案
 *
 * 输入
 * 输入第一行仅包含一个正整数n，表示树包含的结点数量。（1<=n<=100000）
 *
 * 输入第二行包含n-1个数字，第i个数字表示第i个结点的根，我们认为0号结点是整棵树的根，
 * 第i个数字不超过i，即第i个结点的根一定是编号小于i的结点。
 *
 * 输入第三行包含n个数字，第i个数字表是第i-1个结点的颜色，仅由0和1组成，0表示第 i-1号节点的颜色是白色，1表示颜色为黑色。
 *
 * 输出
 * 输出仅包含一个整数，即答案对1000000007取模的结果。
 *
 *
 * 样例输入
 * 3
 * 0 0
 * 1 0 0
 * 样例输出
 * 2
 *
 * 提示
 * 输入样例2
 * 10
 * 0 0 1 2 0 5 1 2 3
 * 1 0 0 1 0 0 1 1 0 1
 *
 * 输出样例2
 * 3
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */

public class 切割树 {

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] color = new int[n];

        // 相连的节点
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 1; i < n; i++) {
            int cur = input.nextInt();
            if (map.get(cur) == null) {
                List<Integer> l = new LinkedList<>();
                l.add(i);
                map.put(cur, l);
            } else {
                map.get(cur).add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            color[i] = input.nextInt();
        }
        int sum = 0;
        final int M = 1000000007;
        int tmp;

        for (int i = 0; i < n; i++) {
            tmp = 0;
            if (color[i] == 0)
                continue;
            List<Integer> l = map.get(i);
            if (l != null) {
                for (int o : l) {
                    if (color[o] == 0)
                        tmp++;
                }
            }
            System.out.println(i + " " + tmp);
            if (tmp > 1) {
                sum = (sum + tmp) % M;
            }
        }
        System.out.println(sum);
    }
}
