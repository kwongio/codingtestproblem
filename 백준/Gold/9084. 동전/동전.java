import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] coin = new int[N];
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = coin[i]; j <= M; j++) {
                    dp[j] += dp[j - coin[i]];
                }
            }
            System.out.println(dp[M]);
        }
    }
}
