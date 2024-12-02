import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]>[] list;
    static int[] distance;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[num].add(new int[]{a, b});
            list[a].add(new int[]{num, b});
        }

        int idx = BFS(1);
        int bfs = BFS(idx);
        System.out.println(distance[bfs]);
    }

    private static int BFS(int start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        distance = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        q.add(new int[]{start, 0});
        distance[start] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int cost = now[1];
            if (visit[cur]) {
                continue;
            }
            visit[cur] = true;
            for (int[] next : list[cur]) {
                if (distance[next[0]] > next[1] + distance[cur]) {
                    distance[next[0]] = next[1] + distance[cur];
                    q.add(new int[]{next[0], distance[next[0]]});
                }
            }
        }
        int max = -1;
        int idx = -1;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                if (max < distance[i]) {
                    max = distance[i];
                    idx = i;
                }
            }
        }
        return idx;
    }
}