import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final int RED = 0;
    static final int BLUE = 1;
    static final int GREEN = 2;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[1000][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][RED] = Integer.parseInt(st.nextToken());
            dp[i][BLUE] = Integer.parseInt(st.nextToken());
            dp[i][GREEN] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            dp[i][RED] += Math.min(dp[i - 1][BLUE], dp[i - 1][GREEN]);
            dp[i][BLUE] += Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
            dp[i][GREEN] += Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
        }
        System.out.println(Math.min(Math.min(dp[N - 1][RED], dp[N - 1][GREEN]), dp[N - 1][BLUE]));
    }
}