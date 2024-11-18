import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static int N;
    static ArrayDeque<int[]> map = new ArrayDeque<>();
    static  boolean[][][] visited;

    // 바다 : 0 , 육지 : 1
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][N];
        int color = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && arr[i][j] != 0) {
                    fillColor(i, j, color);
                    color++;
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
      visited = new boolean[color + 1][N][N];
        BFS();

    }

    private static void BFS() {
        while (!map.isEmpty()) {
            int[] now = map.poll();
            int x = now[0];
            int y = now[1];
            int color = now[2];
            int count = now[3];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[color][nx][ny]) {
                    visited[color][nx][ny] = true;
                    if (arr[nx][ny] == 0) {
                        map.add(new int[]{nx, ny, color, count + 1});
                    } else if (arr[nx][ny] != color) {
                        System.out.println(count );
                        return;
                    }
                }
            }
        }
    }


    private static void fillColor(int sx, int sy, int color) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visit[sx][sy] = true;
        arr[sx][sy] = color;
        map.add(new int[]{sx, sy, color, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && arr[nx][ny] != 0) {
                    visit[nx][ny] = true;
                    arr[nx][ny] = color;
                    map.add(new int[]{nx, ny, color, 0});
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}