import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int[][] board;
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N][(1 << N)];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }


        int dfs = DFS(0, 1);
        System.out.println(dfs);
    }

    private static int DFS(int start, int visit) {
        if (visit == (1 << N) - 1) {
            return board[start][0] == 0 ? 99999999 : board[start][0];
        }

        if (dp[start][visit] != -1) {
            return dp[start][visit];
        }
        dp[start][visit] = 99999999;

        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) != 0) continue;
            if (board[start][i] == 0) continue;
            dp[start][visit] = Math.min(dp[start][visit], DFS(i, (visit | (1 << i))) + board[start][i]);
        }


        return dp[start][visit];

    }
}

