import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    static int N;
    static List<Integer>[] list;
    static int[] dis;
    static boolean[] visit;
    static boolean[] cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        visit = new boolean[N + 1];
        cycle = new boolean[N + 1];
        dis = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            visit = new boolean[N + 1];
            DFS(i, i, 1);
        }
        for (int i = 1; i < N + 1; i++) {
            if (cycle[i]) continue;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            boolean[] vis = new boolean[N + 1];
            q.add(new int[]{i, 0});
            vis[i] = true;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if (cycle[now[0]]) {
                    dis[i] = now[1];
                    break;
                }
                for (Integer next : list[now[0]]) {
                    if (!vis[next]) {
                        vis[next] = true;
                        q.add(new int[]{next, now[1] + 1});
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(dis[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void DFS(int cur, int start, int depth) {
        visit[cur] = true;
        for (int next : list[cur]) {
            if (!visit[next]) {
                DFS(next, start, depth + 1);
            } else {
                if (next == start && depth >= 3) {
                    cycle[start] = true;
                    return;
                }
            }
        }
    }
}