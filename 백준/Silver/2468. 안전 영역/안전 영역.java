import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int height;
    static int maxHeight;
    static int maxCount = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }
        for (int i = 0; i <= maxHeight; i++) {
            height = i;
            visited = new boolean[N][N];
            rain();
            int count = 0;
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[k][j]){
                        BFS(k, j);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);


    }

    private static void BFS(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && ny < N && ny >= 0 && nx < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void rain() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= height) {
                    visited[i][j] = true;
                }
            }
        }
    }
}