import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int X;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int[] dis = new int[N + 1];
        int[] dis1 = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
        }

        extracted(dis, X);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            Arrays.fill(dis1, Integer.MAX_VALUE);
            extracted(dis1, i);
            max = Math.max(max, dis[i] + dis1[X]);
        }
        System.out.println(max);
    }

    private static void extracted(int[] dis, int X) {
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        q.add(new int[]{X, 0});
        boolean[] visit = new boolean[N + 1];
        dis[X] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int cnt = now[1];
            if (visit[cur]) continue;
            visit[cur] = true;
            for (int[] next : list[cur]) {
                if (dis[next[0]] > cnt + next[1]) {
                    dis[next[0]] = cnt + next[1];
                    q.add(new int[]{next[0], dis[next[0]]});
                }
            }
        }
    }
}