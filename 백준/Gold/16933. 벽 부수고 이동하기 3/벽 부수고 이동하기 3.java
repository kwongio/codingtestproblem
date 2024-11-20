import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static int N, M, K;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(BFS(0, 0));


    }

    private static int BFS(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, 1, K, 0}); // 낮부터 시작
        q.add(new int[]{sx, sy, 2, K, 1}); //이동하지 않음
        boolean[][][][] visit = new boolean[2][K + 1][N][M];
        visit[0][K][0][0] = true;
        visit[1][K][0][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int k = now[3];
            int time = now[4];
            if (x == N - 1 && y == M - 1) {
                return cnt;
            }

            if (!visit[time][k][x][y] && time == 1) { //밤일 떄 그냥 한번 넘어감
                visit[time][k][x][y] = true;
                q.add(new int[]{x, y, cnt + 1, k, 0});
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (!isRange(nx, ny)) {
                    continue;
                }
                if (k > 0) {
                    if (!visit[time][k - 1][nx][ny] && arr[nx][ny] == 1 && time == 0) {
                        visit[0][k - 1][nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1, k - 1, 1});
                    }
                }

                if (arr[nx][ny] == 0 & !visit[time][k][nx][ny]) {
                    if (time == 0) {
                        visit[0][k][nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1, k, 1});
                    } else {
                        visit[1][k][nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1, k, 0});
                    }
                }


            }
        }
        return -1;
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}