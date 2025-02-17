import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

class Main {
    static int N, M, K;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, 0, 0);
        System.out.println(max);
    }

    private static void DFS(int x, int y, int count, int total) {
        if (count == K) {
            max = Math.max(max, total);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = (i == x) ? y : 0; j < M; j++) {
                if (!visit[i][j]) {
                    if (isMove(i, j)) {
                        visit[i][j] = true;
                        DFS(i, j, count + 1, total + map[i][j]);
                        visit[i][j] = false;

                    }
                }
            }
        }
    }

    private static boolean isMove(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && visit[nx][ny]) {
                return false;
            }
        }
        return true;
    }
}
