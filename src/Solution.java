import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = 10000;
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        // 注意这里是如何创建的
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            g[u].add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        dis[k - 1] = 0;
        pq.offer(new int[]{k - 1, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int i = node[0];
            int d = node[1];
            if (d > dis[i]) continue;
            for (int[] edge : g[i]) {
                int j = edge[0];
                if (dis[j] > dis[i] + edge[1]) {
                    dis[j] = dis[i] + edge[1];
                    pq.offer(new int[]{j, dis[j]});
                }
            }
        }
        int ans = Arrays.stream(dis).max().getAsInt();
        return ans;
    }
}