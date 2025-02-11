import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int N;
    static int[][] dp;
    static final int INF = 16_000_000; // 충분히 큰 값 (N 최대 16, 최대 비용 1_000_000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][(1 << N)];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1); // -1로 초기화하여 방문 여부 체크
        }

        int result = DFS(0, 1); // 0번 도시에서 시작, 0번 도시 방문한 상태 (0001)
        System.out.println(result);
    }

    private static int DFS(int start, int visit) {
        if (visit == (1 << N) - 1) { // 모든 도시 방문 완료
            return board[start][0] == 0 ? INF : board[start][0]; // 원래 출발점(0)으로 돌아가는 비용
        }

        if (dp[start][visit] != -1) { // 이미 계산된 경우
            return dp[start][visit];
        }

        dp[start][visit] = INF; // 최소값을 찾기 위해 INF로 초기화

        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) != 0) continue; // 이미 방문한 도시라면 스킵
            if (board[start][i] == 0) continue; // 갈 수 없는 도시라면 스킵

            int newVisit = visit | (1 << i);
            dp[start][visit] = Math.min(dp[start][visit], DFS(i, newVisit) + board[start][i]);
        }

        return dp[start][visit];
    }
}
