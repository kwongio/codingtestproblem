import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K;
    static char[][] board;
    static boolean[][] visit;

    static int[] dx = {1, -1, 0, 0};

    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }

        }

        visit[R - 1][0] = true;

        DFS(R - 1, 0, 1);
        System.out.println(answer);
    }

    private static void DFS(int sx, int sy, int count) {
        if (count > K) return;

        if (sx == 0 && sy == C - 1 && count == K) {
            answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + sx;
            int ny = dy[i] + sy;
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visit[nx][ny] && board[nx][ny] == '.') {
                visit[nx][ny] = true;
                DFS(nx, ny, count + 1);
                visit[nx][ny] = false;
            }
        }
    }
}