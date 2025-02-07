import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static List<Integer>[] list;
    static int[] select;
    static int ansA, ansB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        select = new int[2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        DFS(0, 1);
        System.out.println(ansA + " " + ansB + " " + min);
    }

    private static void DFS(int depth, int s) {
        if (depth == 2) {
            cal();
            return;
        }
        for (int i = s; i <= N; i++) {
            select[depth] = i;
            DFS(depth + 1, i + 1);
        }
    }

    private static void cal() {
        int[] dis = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));
        q.add(new int[]{select[0], 0});
        q.add(new int[]{select[1], 0});
        dis[select[0]] = 0;
        dis[select[1]] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int cnt = now[1];
            if (visit[cur]) continue;
            visit[cur] = true;
            for (int next : list[cur]) {
                if (dis[next] > dis[cur] + cnt + 1) {
                    dis[next] = dis[cur] + cnt + 1;
                    q.add(new int[]{cur, dis[next]});
                }
            }
        }
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (dis[i] == Integer.MAX_VALUE) return;
            sum += dis[i];
        }
        if (sum * 2 < min) {
            ansA = select[0];
            ansB = select[1];
            min = sum * 2;
        }
    }
}