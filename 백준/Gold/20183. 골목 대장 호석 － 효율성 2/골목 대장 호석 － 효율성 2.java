import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, A, B;
    static long C;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 교차로 개수
        M = Integer.parseInt(st.nextToken());// 골목 개수
        A = Integer.parseInt(st.nextToken());// 시작 교차로
        B = Integer.parseInt(st.nextToken());// 도착
        C = Long.parseLong(st.nextToken());//가진 돈
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
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
        getDistance(A, B);
    }


    static void getDistance(int s, int e) {
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
        q.add(new long[]{s, 0, 0}); // 경로, 돈, 최대 수치심
        boolean[] visit = new boolean[N + 1];
        long[] dis = new long[N + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[s] = 0;
        while (!q.isEmpty()) {
            long[] now = q.poll();
            int cur = (int) now[0];
            long money = now[1];
            long value = now[2];
            if (now[0] == e) {
                System.out.println(value);
                return;
            }
            if (visit[cur]) continue;
            visit[cur] = true;
            for (int[] next : list[cur]) {
                if (dis[next[0]] > money + next[1] && money + next[1] <= C) {
                    dis[next[0]] = money + next[1];
                    q.add(new long[]{next[0], dis[next[0]], Math.max(next[1], value)});
                }
            }
        }
        System.out.println(-1);
    }
}