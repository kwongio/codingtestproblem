import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int K;
    static List<List<int[]>> list;
    static int[] des;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());// 지나간 도로 g h
            int h = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list.get(a).add(new int[]{b, d});
                list.get(b).add(new int[]{a, d});
            }

            des = new int[t];
            for (int j = 0; j < t; j++) {
                st = new StringTokenizer(br.readLine());
                des[j] = Integer.parseInt(st.nextToken());
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < t; j++) {
                int res1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, des[j]);
                int res2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, des[j]);
                int res3 = dijkstra(s, des[j]);
                if (Math.min(res1, res2) == res3) {
                    pq.add(des[j]);
                }
            }
            while (!pq.isEmpty()) {
                System.out.print(pq.poll()+" ");
            }
            System.out.println();
        }
    }

    private static int dijkstra(int start, int end) {
        distance = new int[n + 1];
        for (int j = 1; j < n + 1; j++) distance[j] = 10000000;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(o1 -> o1[1]));
        q.add(new int[]{start, 0});
        distance[start] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (distance[now[0]] < now[1]) continue;
            for (int[] next : list.get(now[0])) {
                if (distance[next[0]] > distance[now[0]] + next[1]) {
                    distance[next[0]] = distance[now[0]] + next[1];
                    q.add(new int[]{next[0], distance[next[0]]});
                }
            }
        }
        return distance[end];
    }
}