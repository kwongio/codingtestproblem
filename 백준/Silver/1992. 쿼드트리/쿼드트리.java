import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] v = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(v[j]);
            }
        }
        DFS(0, 0, N);
        System.out.println(sb);
    }



    private static void DFS(int x, int y, int size) {
        if (check(x, y, size, board[x][y])) {
            if (board[x][y] == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            return;
        }
        sb.append("(");
        DFS(x, y, size / 2);
        DFS(x, y + size / 2, size / 2);
        DFS(x + size / 2, y, size / 2);
        DFS(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
    }

    private static boolean check(int x, int y, int size, int color) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != color)
                    return false;
            }
        }
        return true;
    }
}