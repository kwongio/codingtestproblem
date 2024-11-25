import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static List<Integer>[] list;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        total = N + M;

        list = new ArrayList[total];
        for (int i = 0; i < total; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int next = Integer.parseInt(st.nextToken()) - 1;
                list[N + i].add(next);
                list[next].add(N + i);
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        visit = new boolean[total];
        q.add(new int[]{0, 1});
        visit[0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int cnt = now[1];
            if (cur == N - 1) {
                System.out.println(cnt);
                return;
            }
            for (int next : list[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new int[]{next, next >= N ? cnt + 1 : cnt});
                }
            }
        }
        System.out.println(-1);
    }
}