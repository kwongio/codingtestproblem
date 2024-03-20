import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int M;
    static List<int[]>[] list;
    static int start = 1; //시작 지점
    static int answer = 0;
    static int min;
    static int[] path;

    public static void main(String[] args) throws IOException {
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

        dijkstra();
//        for (int i = N; i > start ; i = path[i]) {
//            maxDistance(i , path[i]);
//        }
        DFS(N);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer - min);
    }

    public static void DFS(int p) {
        if (path[p] != 0) {
            maxDistance(p, path[p]);
            DFS(path[p]);
        }
    }

    private static void dijkstra() {
        boolean[] visited = new boolean[N + 1];
        path = new int[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[]{start, 0});
        distance[start] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            if (visited[x]) continue;
            visited[x] = true;
            for (int[] next : list[x]) {
                int nx = next[0];
                int ny = next[1];
                if (distance[nx] > y + ny) {
                    distance[nx] = y + ny;
                    q.add(new int[]{nx, distance[nx]});
                    path[nx] = x;
                }
            }
        }
        min = distance[N];
    }

    private static void maxDistance(int v1, int v2) {
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[]{start, 0});
        distance[start] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            if (visited[x]) continue;
            visited[x] = true;
            for (int[] next : list[x]) {
                if ((v1 == x && v2 == next[0]) || (v1 == next[0] && v2 == x)) continue;
                int nx = next[0];
                int ny = next[1];
                if (distance[nx] > y + ny) {
                    distance[nx] = y + ny;
                    q.add(new int[]{nx, distance[nx]});
                }
            }
        }
        answer = Math.max(distance[N], answer);
    }
}