import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] visit = new int[2][500_005];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
            System.exit(0);
        }
        BFS(N);

    }

    private static void BFS(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int time = 1;
        q.offer(start);
        visit[0][start] = 1;
        while (!q.isEmpty()) {
            K += time;
            if (K > 500000) {
                System.out.println(-1);
                System.exit(0);
            }
            if (visit[time % 2][K] > 0) {
                System.out.println(time);
                System.exit(0);
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                for (int nx : new int[]{now + 1, now - 1, now * 2}) {
                    if (nx >= 0 && nx <= 500000) {
                        if (visit[time % 2][nx] == 0) {
                            visit[time % 2][nx] = visit[(time + 1) % 2][now] + 1;
                            q.offer(nx);
                            if (nx == K) {
                                System.out.println(time);
                                System.exit(0);
                            }
                        }
                    }
                }
            }
            time++;
        }
    }
}