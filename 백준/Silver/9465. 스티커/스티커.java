import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, T;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int testCase = 0; testCase < T; testCase++) {
            int ans = 0;
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[2][N];
            dp = new int[2][N + 1];
            visit = new boolean[2][N];
            for (int i = 0; i < N; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            dp[0][N - 1] = arr[0][N - 1];
            dp[1][N - 1] = arr[1][N - 1];
            for (int i = N - 2; i >= 0; i--) {
                dp[0][i] = Math.max(dp[1][i + 1], dp[1][i + 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i + 1], dp[0][i + 2]) + arr[1][i];
            }
            System.out.println(Math.max(dp[0][0], dp[1][0]));
        }
    }
}