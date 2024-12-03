import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


         DFS(0, 0);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[0][0] + arr[0][0]);
    }

    private static int DFS(int x, int y) {
        if (x == N - 1) {
            return 0;
        }
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = Math.max(DFS(x + 1, y) + arr[x + 1][y], DFS(x + 1, y + 1) + arr[x + 1][y + 1]);

        return dp[x][y];
    }
}