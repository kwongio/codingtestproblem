import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    //북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int direction = 0;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(r, c, direction);
        System.out.println(count);

    }

    private static void DFS(int x, int y, int d) {

        map[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                count++;
                DFS(nx, ny, d);
                return;
            }
        }

        int dir = (d + 2) % 4;
        int nx = dx[dir] + x;
        int ny = dy[dir] + y;
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1) {
            DFS(nx, ny, d);
        }
    }
}