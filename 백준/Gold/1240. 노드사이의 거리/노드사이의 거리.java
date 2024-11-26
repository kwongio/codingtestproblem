import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, M;
    static List<int[]>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //LCA문제 두 노드 사이의 거리
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new int[]{b, c});
            tree[b].add(new int[]{a, c});
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            BFS(a, b);
        }
    }

    private static void BFS(int a, int b) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, 0});
        boolean[] visit = new boolean[N + 1];
        visit[a] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == b) {
                System.out.println(now[1]);
                return;
            }
            for (int[] next : tree[now[0]]) {
                if (visit[next[0]]) continue;
                visit[next[0]] = true;
                q.add(new int[]{next[0], next[1] + now[1]});
            }
        }
    }
}