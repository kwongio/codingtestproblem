import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, W, T;
    static PriorityQueue<int[]>[] list;
    static boolean[] visit;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지점의 수
            M = Integer.parseInt(st.nextToken()); // 도로 정보
            W = Integer.parseInt(st.nextToken()); // 웜홀 개수
            list = new PriorityQueue[N + 1];
            for (int j = 0; j < N + 1; j++) {
                list[j] = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); // 연결 지점
                int e = Integer.parseInt(st.nextToken()); // 연결 지점
                int t = Integer.parseInt(st.nextToken()); // 시간
                list[s].add(new int[]{e, t});
                list[e].add(new int[]{s, t});
            }

            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); // 연결 지점
                int e = Integer.parseInt(st.nextToken()); // 연결 지점
                int t = Integer.parseInt(st.nextToken()); // 줄어드는 시산
                list[s].add(new int[]{e, -t});
            }

            boolean cycle = false;
            for (int j = 1; j <= N; j++) {
                if (getDistance(j)) {
                    System.out.println("YES");
                    cycle = true;
                    break;
                }
            }
            if (!cycle) {
                System.out.println("NO");
            }
        }
    }

    private static boolean getDistance(int start) {
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;
            for (int j = 1; j <= N; j++) {
                for (int[] next : list[j]) {
                    if (dis[j] != Integer.MAX_VALUE && dis[next[0]] > dis[j] + next[1]) {
                        dis[next[0]] = dis[j] + next[1];
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (int[] next : list[i]) {
                    if (dis[i] != Integer.MAX_VALUE && dis[next[0]] > dis[i] + next[1]) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}