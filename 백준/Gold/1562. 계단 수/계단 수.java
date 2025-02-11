import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //자리수, 현재 숫자,

        dp = new int[N + 1][10][(1 << 10)];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 1; i < N; i++) { // 자리수
            for (int j = 0; j <= 9; j++) { //다음 숫자
                for (int k = 0; k < (1 << 10); k++) { // 0 ~ 1023
                    if (dp[i][j][k] == 0) continue;

                    if (j > 0) {
                        int next = k | (1 << (j - 1));
                        dp[i + 1][j - 1][next] = (dp[i + 1][j - 1][next] + dp[i][j][k]) % 1_000_000_000;
                    }
                    if (j < 9) {
                        int next = k | (1 << (j + 1));
                        dp[i + 1][j + 1][next] = (dp[i + 1][j + 1][next] + dp[i][j][k]) % 1_000_000_000;
                    }
                }
            }
        }
        long result = 0;
        int fullMask = (1 << 10) - 1; // 모든 숫자(0~9)가 사용된 상태

        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j][fullMask]) % 1_000_000_000;
        }

        System.out.println(result);
    }
}
