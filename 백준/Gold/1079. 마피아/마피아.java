import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 플레이어 수

    static int me;

    static int[] score;

    static int[][] map;

    static boolean[] died;

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N];
        map = new int[N][N];
        died = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        me = Integer.parseInt(br.readLine());

        DFS(0, N % 2, N);
        System.out.println(ans);
    }

    private static void DFS(int days, int time, int num) {
        if (died[me] || num == 1) {
            ans = Math.max(days, ans);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (died[i]) continue;
            if (time == 0) { //밤에는 아무나 죽일 수 있음
                if (i == me) continue;
                died[i] = true;
                for (int j = 0; j < N; j++) {
                    score[j] += map[i][j];
                }
                DFS(days + 1, 1, num - 1);
                for (int j = 0; j < N; j++) {
                    score[j] -= map[i][j];
                }
                died[i] = false;
            } else if (time == 1) { // 낮
                if (isTop(i)) {
                    died[i] = true;
                    DFS(days, 0, num - 1);
                    died[i] = false;
                }
            }
        }
    }

    private static boolean isTop(int index) {
        int max = -1;
        int mIdx = -1;
        for (int i = 0; i < N; i++) {
            if (died[i]) continue;
            if (max < score[i]) {
                max = score[i];
                mIdx = i;
            }
        }
        return index == mIdx;
    }

}
