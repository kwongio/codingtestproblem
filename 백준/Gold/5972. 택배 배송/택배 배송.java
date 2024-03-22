import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<int[]>[] list;
    static int start = 1;
    static int[] distance;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});

        }
        dijkstra(start);
        System.out.println(distance[N]);


    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[]{start, 0});
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        boolean[] visited = new boolean[N + 1];
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            for (int[] next : list[now[0]]) {
                if (distance[next[0]] > distance[now[0]] + next[1]) {
                    distance[next[0]] = distance[now[0]] + next[1];
                    q.add(new int[]{next[0], distance[next[0]]});
                }
            }
        }
    }
}