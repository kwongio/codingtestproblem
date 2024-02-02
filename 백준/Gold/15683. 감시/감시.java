import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;

    static List<Camera> cameras = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cameras.add(new Camera(i, j, map[i][j]));
                }
            }
        }


        DFS(0);
        System.out.println(answer);
    }

    static void DFS(int depth) {
        if (depth == cameras.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }
            answer = Math.min(answer, count);
            return;
        }
        Camera camera = cameras.get(depth);

        for (int d = 0; d < 4; d++) {
            if (camera.num == 1) {
                move(camera.x, camera.y, d, true);
                DFS(depth + 1);
                move(camera.x, camera.y, d, false);
            } else if (camera.num == 2) {
                move(camera.x, camera.y, d, true);
                move(camera.x, camera.y, (d + 2) % 4, true);
                DFS(depth + 1);
                move(camera.x, camera.y, d, false);
                move(camera.x, camera.y, (d + 2) % 4, false);
            } else if (camera.num == 3) {
                move(camera.x, camera.y, d, true);
                move(camera.x, camera.y, (d + 1) % 4, true);
                DFS(depth + 1);
                move(camera.x, camera.y, d, false);
                move(camera.x, camera.y, (d + 1) % 4, false);
            } else if (camera.num == 4) {
                move(camera.x, camera.y, d, true);
                move(camera.x, camera.y, (d + 1) % 4, true);
                move(camera.x, camera.y, (d + 2) % 4, true);
                DFS(depth + 1);
                move(camera.x, camera.y, d, false);
                move(camera.x, camera.y, (d + 1) % 4, false);
                move(camera.x, camera.y, (d + 2) % 4, false);
            } else if (camera.num == 5) {
                move(camera.x, camera.y, d, true);
                move(camera.x, camera.y, (d + 1) % 4, true);
                move(camera.x, camera.y, (d + 2) % 4, true);
                move(camera.x, camera.y, (d + 3) % 4, true);
                DFS(depth + 1);
                move(camera.x, camera.y, d, false);
                move(camera.x, camera.y, (d + 1) % 4, false);
                move(camera.x, camera.y, (d + 2) % 4, false);
                move(camera.x, camera.y, (d + 3) % 4, false);
            }
        }

    }

    public static void move(int x, int y, int d, boolean check) {
        while (true) {
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 6) break;
            x = nx;
            y = ny;
            if (check) {
                map[nx][ny]++;
            } else if (map[nx][ny] > 0) {
                map[nx][ny]--;
            }
        }

    }

    static class Camera {
        public int x;
        public int y;
        public int num;

        public Camera(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.num = number;
        }

        @Override
        public String toString() {
            return "Camera{" +
                    "x=" + x +
                    ", y=" + y +
                    ", num=" + num +
                    '}';
        }
    }
}
