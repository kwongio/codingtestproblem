import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]>[] list;
    static int[] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        pre = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        q.add(new int[]{a, 0});
        boolean[] visit = new boolean[N + 1];
        dis[a] = 0;
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
                    pre[next[0]]= cur;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        sb.append(dis[b]).append("\n");
        path.add(b);
        while (pre[b] != 0) {
            path.add(pre[b]);
            b = pre[b];
        }
        sb.append(path.size()).append("\n");
        while (!path.isEmpty()) {
            sb.append(path.pollLast()).append(" ");
        }
        System.out.println(sb);
    }

}