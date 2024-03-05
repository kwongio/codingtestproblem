import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] RGB;
    static int[][] B;
    static int rgbCount;
    static int bCount;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        RGB = new int[N][N];
        B = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                String input = split[j];
                if (input.equals("R")) {
                    RGB[i][j] = 1;
                    B[i][j] = 1;
                } else if (input.equals("G")) {
                    RGB[i][j] = 2;
                    B[i][j] = 1;
                } else if (input.equals("B")) {
                    RGB[i][j] = 3;
                    B[i][j] = 3;
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && (RGB[i][j] == 1 || RGB[i][j] == 2 || RGB[i][j] == 3)) {
                    rgbCount++;
                    BFS(i, j, RGB[i][j], RGB);
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && (B[i][j] == 1 || B[i][j] == 3)) {
                    bCount++;
                    BFS(i, j, B[i][j], B);
                }
            }
        }
        System.out.println(rgbCount + " " + bCount);


    }

    private static void BFS(int x, int y, int color, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == color) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}