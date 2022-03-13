import java.util.*;

class Solution {

    List<long[]>[] g;
    List<long[]>[] rg;
    final long INF = Long.MAX_VALUE / 10;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        // 初始化邻接表
        g = new List[n];
        rg = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int f = edges[i][0];
            int t = edges[i][1];
            int w = edges[i][2];
            g[f].add(new long[]{t, w});
            rg[f].add(new long[]{f, w});
        }
        // 3次dijkstra
        long[] dis1 = new long[n];
        long[] dis2 = new long[n];
        long[] dis3 = new long[n];
        dijkstra(src1, dis1, g);
        dijkstra(src2, dis2, g);
        dijkstra(dest, dis3, rg);
        // 遍历每一个节点
        long ans = INF;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dis1[i] + dis2[i] + dis3[i]);
        }
        return ans >= INF ? -1 : ans;
    }

    private void dijkstra(int src, long[] dis, List<long[]>[] g) {
        int n = dis.length;
        dis = new long[n];
        Arrays.fill(dis, INF);
        dis[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[1] - o2[1]));
        pq.offer(new long[]{src, 0});
        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            int i = (int) node[0];
            long d = node[1];
            if (d > dis[i]) continue;
            for (long[] edge : g[i]) {
                int j = (int) edge[0];
                if (dis[j] > dis[i] + edge[1]) {
                    dis[j] = dis[i] + edge[1];
                    pq.offer(new long[]{j, dis[j]});
                }
            }
        }
        System.out.println(Arrays.toString(dis));
    }

}