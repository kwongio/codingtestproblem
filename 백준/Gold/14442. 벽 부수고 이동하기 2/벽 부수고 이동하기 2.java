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
        //0은 이동가능  1은 벽
        //0,0 에서 N -1, M -1로 이동
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
        q.add(new int[]{sx, sy, 1, K});  
        boolean[][][] visit = new boolean[K + 1][N][M];
        visit[K][0][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int k = now[3];
            if (x == N - 1 && y == M - 1) {
                return cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (k > 0) {
                    if (isRange(nx, ny) && !visit[k - 1][nx][ny] && arr[nx][ny] == 1) { // 벽일떄
                        visit[k - 1][nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1, k - 1});
                    }
                }
                if (isRange(nx, ny) && !visit[k][nx][ny] && arr[nx][ny] == 0) {
                    visit[k][nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt + 1, k});
                }
            }
        }
        return -1;
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}