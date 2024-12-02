import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N;
    static int[][] map; // 대나무 숲
    static int[][] d;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        d = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, DFS(i, j));
            }
        }

        System.out.println(ans);
    }

    public static int DFS(int x, int y) {
        if (d[x][y] != 0) {
            return d[x][y];
        }
        d[x][y] = 1;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (map[x][y] < map[nx][ny]) {
                d[x][y] = Math.max(d[x][y], DFS(nx, ny) + 1);
            }
        }
        return d[x][y];
    }

}