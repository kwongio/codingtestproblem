import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;


    static int[][] map;
    static int[][] move;

    static Queue<Cloud> clouds = new LinkedList<>();
    static boolean[][] visited;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {

        }
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s  = Integer.parseInt(st.nextToken());
            move(d, s);
            rainCopy();
            createCloud();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += map[i][j];
            }
        }
        System.out.println(count);


    }

    private static void move(int d, int s) {
        for (Cloud cloud : clouds) {
            cloud.x = (N + dx[d] * (s % N) + cloud.x) % N;
            cloud.y = (N + dy[d] * (s % N) + cloud.y) % N;
            map[cloud.x][cloud.y]++;
        }
    }
    private static void rainCopy() {
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();
            int cnt = 0;
            visited[cloud.x][cloud.y] = true;
            for (int k = 1; k <= 7; k += 2) {
                int nx = dx[k] + cloud.x;
                int ny = dy[k] + cloud.y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] >= 1) {
                        cnt++;
                    }
                }
            }
            map[cloud.x][cloud.y] += cnt;
        }
    }



    private static void createCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
        visited = new boolean[N][N];
    }
}