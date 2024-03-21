import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][][] visited;
    static int K;
    static int H;
    static int W;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(0, 0);
        System.out.println(-1);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 0, K});
        visited[0][0][K] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == H - 1 && now[1] == W - 1) {
                System.out.println(now[2]);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !visited[nx][ny][now[3]]) {
                    visited[nx][ny][now[3]] = true;
                    q.add(new int[]{nx, ny, now[2] + 1, now[3]});
                }
            }
            if (now[3] == 0) continue;
            for (int i = 0; i < 8; i++) {
                int nx = hx[i] + now[0];
                int ny = hy[i] + now[1];
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !visited[nx][ny][now[3] - 1]) {
                    visited[nx][ny][now[3] - 1] = true;
                    q.add(new int[]{nx, ny, now[2] + 1, now[3] - 1});
                }
            }
        }
    }
}