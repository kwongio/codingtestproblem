import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static List<int[]>[] list;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result = dijkstra(1, v1);
        result += dijkstra(v1, v2);
        result += dijkstra(v2, N);

        int result2 = dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);
        if(result2 >= 100000001 && result >= 100000001){
            System.out.println(-1);
        }else{
             result = Math.min(result2, result);
            System.out.println(result);
        }
    }

    private static int dijkstra(int s, int e) {
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distance[i] = 100000001;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[]{s, 0});
        distance[s] = 0;
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
        return distance[e];
    }
}