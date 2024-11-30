import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

class Main {

    static int max = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] arr;
    static boolean[][] visit = new boolean[N][M];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                DFS(i, j, 1, arr[i][j]);
                visit[i][j] = true;
            }
        }
        System.out.println(max);
    }

    private static void DFS(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                visit[nx][ny] = true;
                DFS(x, y, cnt + 1, sum + arr[nx][ny]);
                DFS(nx, ny, cnt + 1, sum + arr[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }
}