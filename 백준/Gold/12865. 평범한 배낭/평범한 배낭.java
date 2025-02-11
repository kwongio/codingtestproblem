import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭 최대 무게

        int[] dp = new int[K + 1]; // 1차원 DP 배열 선언

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()); // 물건 무게
            int value = Integer.parseInt(st.nextToken()); // 물건 가치

            for (int w = K; w >= weight; w--) { // 🔥 뒤에서부터 갱신
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }

        System.out.println(dp[K]); // 최대 가치 출력
    }
}
