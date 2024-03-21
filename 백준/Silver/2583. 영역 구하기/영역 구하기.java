import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            for (int j = sx; j < dx; j++) {
                for (int k = sy; k < dy; k++) {
                    map[j][k] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    count++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(count);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }

    private static void BFS(int x, int y) {
        int sum = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    sum++;
                }
            }
        }
        pq.add(sum);

    }
}