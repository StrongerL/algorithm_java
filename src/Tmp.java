import java.util.*;

public class Tmp {

    // 测试

    public static void main(String[] args) {

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Queue<Integer> q  = new PriorityQueue<>(cmp);

        q.offer(10);
        q.offer(20);

        System.out.println(q.peek());




    }

}
