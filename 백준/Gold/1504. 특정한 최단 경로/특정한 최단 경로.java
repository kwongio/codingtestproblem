import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<List<int[]>> list;
    static int[] distance;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new int[]{end, cost});
            list.get(end).add(new int[]{start, cost});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result = dikstra(1, v1);
        result += dikstra(v1, v2);
        result += dikstra(v2, N);


        int result2 = dikstra(1, v2);
        result2 += dikstra(v2, v1);
        result2 += dikstra(v1, N);
        if (result2 >= 100000001 && result >= 100000001) {
            System.out.println(-1);
        }else{
            result = Math.min(result2, result);
            System.out.println(result);

        }


    }

    private static int dikstra(int start, int end) {
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distance[i] = 100000001;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.add(new int[]{start, 0});
        distance[start] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
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