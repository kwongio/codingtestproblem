import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();
        int N = c1.length;
        int M = c2.length;
        int[][] dp = new int[N + 1][M + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[N][M]);
        if (dp[N][M] != 0) {
            int x = N;
            int y = M;
            Stack<Character> st = new Stack<>();
            while (x > 0 && y > 0) {
                if (x == 0 || y == 0) {
                    break;
                }
                if (dp[x][y] == dp[x - 1][y]) {
                    x--;
                } else if (dp[x][y] == dp[x][y - 1]) {
                    y--;
                } else {
                    st.push(c1[x - 1]);
                    x--;
                    y--;
                }
            }
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            System.out.println(sb);
        }
    }
}
