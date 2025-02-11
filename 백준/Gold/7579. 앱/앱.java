import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mem = new int[N];
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
        }

        int totalCosts = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            totalCosts += cost[i];
        }

        int[] dp = new int[totalCosts + 1];
        for (int i = 0; i < N; i++) {
            for (int j = totalCosts; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + mem[i]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= totalCosts; i++) {
            if (dp[i] >= M) {
                answer = Math.min(answer, i);
            }
        }
        System.out.println(answer);
    }
}
