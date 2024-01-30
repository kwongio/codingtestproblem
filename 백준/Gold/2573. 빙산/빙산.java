import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> q;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            visited = new boolean[N][M];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        landCount(i, j);
                        count++;
                        if (count == 2) {
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }

            if(count == 0){
                System.out.println(0);
                return;
            }
            melt();
            answer++;
        }
    }

    private static void landCount(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] =true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static void melt() {
        q = new LinkedList<>();
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 1) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int count = 0;
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        count++;
                    }
                }
            }
            if (map[now[0]][now[1]] - count < 0) {
                map[now[0]][now[1]] = 0;
            } else {
                map[now[0]][now[1]] -= count;
            }
        }
    }
}