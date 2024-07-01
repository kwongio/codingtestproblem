import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] board;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'L') {
                    BFS(i, j);
                }
            }
        }
        System.out.println(max);
    }

    private static void BFS(int sx, int sy) {
        visit = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, 0});
        visit[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cost = now[2];
            max = Math.max(cost, max);
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 'W' && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny, cost + 1});
                }
            }
        }
    }
}