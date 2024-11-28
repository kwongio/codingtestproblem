import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(String.valueOf(str.charAt(j)));
                board[i][j] = a;
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(value -> value[2]));
        q.add(new int[]{0, 0, 0}); // x y cnt
        boolean[][] visit = new boolean[N][M];

        int[] dx = {1, -1, 0, 0,};
        int[] dy = {0, 0, 1, -1};
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            if (x == N - 1 && y == M - 1) {
                System.out.println(cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                    if (board[nx][ny] == 1) {
                        q.add(new int[]{nx, ny, cnt + 1});
                    } else
                        q.add(new int[]{nx, ny, cnt});
                    visit[nx][ny] = true;

                }
            }
        }
    }
}