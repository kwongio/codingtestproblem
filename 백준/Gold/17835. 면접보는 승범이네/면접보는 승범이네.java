import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        List<Integer> room = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            room.add(Integer.parseInt(st.nextToken()));
        }

        long max = Long.MIN_VALUE;
        int index = 0;
        long[] answer = dijkstra( room);
        for (int i = 1; i <= N; i++) {
            if (max < answer[i]) {
                max = answer[i];
                index = i;
            }
        }
        System.out.println(index);
        System.out.println(max);
    }

    private static long[] dijkstra( List<Integer> room) {
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        long[] dis = new long[N + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        for (Integer i : room) {
            q.add(new long[]{i, 0});
            dis[i] = 0;
        }
        boolean[] visit = new boolean[N + 1];
        while (!q.isEmpty()) {
            long[] now = q.poll();
            int cur = (int)now[0];
            if (visit[cur]) {
                continue;
            }
            visit[cur] = true;
            for (int[] next : list[cur]) {
                if (dis[next[0]] > now[1] + next[1]) {
                    dis[next[0]] = now[1] + next[1];
                    q.add(new long[]{next[0], dis[next[0]]});
                }
            }
        }
        return dis;
    }
}