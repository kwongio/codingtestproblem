import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] board;
    static int visit = 0;

    static int[] dx = {1, -1, 0, 0};
    static int max = Integer.MIN_VALUE;
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        visit |= 1 << board[0][0];
        DFS(0, 0, 1);
        System.out.println(max);
    }

    private static void DFS(int sx, int sy, int count) {
        max = Math.max(count, max);
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + sx;
            int ny = dy[i] + sy;
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && (visit &  1<< board[nx][ny]) != 1 << board[nx][ny]) {
                visit |= 1 << board[nx][ny];
                DFS(nx, ny, count + 1);
                visit &= ~(1 << board[nx][ny]);
            }
        }
    }
}