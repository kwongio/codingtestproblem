import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[] dx1 = {1, -1, 0, 0};
    static int[] dy1 = {0, 0, 1, -1};
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS(0, 0));

    }

    private static int BFS(int x, int y) {
        boolean[][][] visit = new boolean[N][M][K + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0, K});
        visit[x][y][K] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == N - 1 && now[1] == M - 1) {
                return now[2];
            }
            if (now[3] > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = dx[i] + now[0];
                    int ny = dy[i] + now[1];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 1 && !visit[nx][ny][now[3] - 1]) {
                        visit[nx][ny][now[3] - 1] = true;
                        q.offer(new int[]{nx, ny, now[2] + 1, now[3] - 1});
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx1[i] + now[0];
                int ny = dy1[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 1 && !visit[nx][ny][now[3]]) {

                    visit[nx][ny][now[3]] = true;
                    q.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                }
            }
        }
        return -1;
    }
}