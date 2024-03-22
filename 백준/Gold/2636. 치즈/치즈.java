import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cheezeCount = 0;
    static int deleteCount =0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheezeCount++;
                }
            }
        }

        int time = 0;
        while (cheezeCount > 0) {
            deleteCount = 0;
            time++;

            air(0, 0);
            check = new boolean[N][M];
            boolean[][] visit = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        BFS(i, j, visit);
                    }
                }
            }
            if(deleteCount == 0) continue;
            if(cheezeCount - deleteCount == 0){
                break;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (check[i][j]) {
                        cheezeCount--;
                        map[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(time);
        System.out.println(deleteCount);
    }

    private static void air(int x, int y) {
        visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void BFS(int x, int y, boolean[][] visit) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (visited[nx][ny] && !check[now[0]][now[1]]) {
                    deleteCount++;
                    check[now[0]][now[1]] = true;
                }
                if (nx > 0 && nx < N - 1 && ny > 0 && ny < M - 1 && map[nx][ny] == 1 && !visit[nx][ny] ) {
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
