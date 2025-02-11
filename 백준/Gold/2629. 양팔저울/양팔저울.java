import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] dp;
    static int[] weights;
    static int N, maxWeight = 15000; // 최대 무게 (500*30 = 15000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 추 개수
        weights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 구슬 개수
        int[] marbles = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][maxWeight + 1]; // DP 테이블
        solve(0, 0); // DP 실행

        StringBuilder sb = new StringBuilder();
        for (int marble : marbles) {
            if (marble > maxWeight) {
                sb.append("N ");
            } else {
                sb.append(dp[N][marble] ? "Y " : "N ");
            }
        }
        System.out.println(sb);
    }

    static void solve(int index, int weight) {
        if (index > N || dp[index][weight]) return; // 이미 방문한 경우 종료
        dp[index][weight] = true;

        if (index < N) {
            solve(index + 1, weight); // 현재 추 사용 X
            solve(index + 1, weight + weights[index]); // 현재 추 사용 (오른쪽)
            solve(index + 1, Math.abs(weight - weights[index])); // 반대편 사용 (왼쪽)
        }
    }
}
