import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static final String ZERO = "No trees.";
    static final String ONE = "There is one tree.";
    static final String TWO = "A forest of T trees.";
    static List<Integer>[] list;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int t = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            list = new ArrayList[N + 1];
            visit = new boolean[N + 1];
            for (int i = 0; i < N + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            int answer = 0;
            for (int i = 1; i < N + 1; i++) {
                if (!visit[i]) {
                    answer += BFS(i);
                }
            }
            sb.append("Case " + t + ": ");
            if (answer == 0) {
                sb.append(ZERO);
            } else if (answer == 1) {
                sb.append(ONE);
            } else if (answer >= 2) {
                sb.append("A forest of " + answer + " trees.");
            }
            sb.append("\n");
            t++;
        }
        System.out.println(sb);
    }

    private static int BFS(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int node = 0;
        int edge = 0;
        q.add(start);
        while (!q.isEmpty()) {
            Integer now = q.poll();
            if (visit[now]) {
                continue;
            }
            visit[now] = true;
            node++;
            for (Integer next : list[now]) {
                q.add(next);
                edge++;
            }
        }
        return (edge / 2) + 1 == node ? 1 : 0;

    }
}
