import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static int N, M;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // (N + 1)/2 이상인 것은 중간이 될 수 없다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        cnt = new int[N + 1];
        for (int i = 1; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
    int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (BFS(i) > (N + 1) / 2) {
              ans++;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (cnt[i] >= (N + 1) / 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static int BFS(int start) {
        int count = 1;
        boolean[] visit = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer next : list[now]) {
                if(!visit[next]){
                    visit[next] = true;
                    count++;
                    cnt[next]++;
                    q.add(next);
                }
            }
        }
        return count;
    }
}