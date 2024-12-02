import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);

        }
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(DFS(i, j), max);
            }
        }
        System.out.println(max);
    }

    private static int DFS(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[x][y] < arr[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}