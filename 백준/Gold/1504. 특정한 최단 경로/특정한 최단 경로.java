import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result1 = geDis(1, a) + geDis(a, b) + geDis(b, N);
        int result2 = geDis(1, b) + geDis(b, a) + geDis(a, N);
        if(result2 >= 100000001 && result1 >= 100000001){
            System.out.println(-1);
        }else{
            result1 = Math.min(result2, result1);
            System.out.println(result1);
        }
    }

    private static int geDis(int s, int e) {
        PriorityQueue<int[]> q = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        q.add(new int[]{s, 0});
        int[] dis = new int[N + 1];
        Arrays.fill(dis, 100000001);
        boolean[] visit = new boolean[N + 1];
        dis[s] = 0;
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
        return dis[e];
    }
}