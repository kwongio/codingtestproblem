import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visit = new int[100003];
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        BFS(N);
        System.out.println(visit[K] - 1);
        System.out.println(cnt[K]);
    }

    private static void BFS(int s) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visit[s] = 1;
        cnt = new int[100003];
        cnt[s] = 1;
        q.offer(s);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int n : new int[]{now + 1, now - 1, now * 2}) {
                if (0 <= n && n <= 100000) {
                    if (visit[n] == 0) {
                        visit[n] = visit[now] + 1;
                        q.offer(n);
                        cnt[n] += cnt[now];
                    } else if (visit[n] == visit[now] + 1) {
                        cnt[n] += cnt[now];
                    }
                }
            }
        }
    }

}