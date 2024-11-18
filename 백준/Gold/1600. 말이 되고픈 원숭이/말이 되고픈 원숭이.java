import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    //말의 움직임
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

    //4방향 인접한 칸
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int T, H, W;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        // K 말처럼 가능
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(arr[i]));
        }
        //맨 왼쪽 위에서 시작해서 0 ,0
        //맨 오른쪽 아래까지 가야함 H -1, W - 1 // 최소한의 동작으로 도착까지 가는법

        BFS(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    private static void BFS(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, T, 0});
        boolean[][][] visit = new boolean[T + 1][H][W];
        visit[T][sx][sy] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int t = now[2];
            int cnt = now[3];

            if (x == H - 1 && y == W - 1) {
                min = Math.min(cnt, min);
                continue;
            }

            //그냥 가기
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[t][nx][ny] && arr[nx][ny] == 0) {
                    visit[t][nx][ny] = true;
                    q.add(new int[]{nx, ny, t, cnt + 1});
                }
            }

            //말처럼 뛰기
            if (t > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = hx[i] + x;
                    int ny = hy[i] + y;
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[t-1][nx][ny] && arr[nx][ny] == 0) {
                        visit[t- 1][nx][ny] = true;
                        q.add(new int[]{nx, ny, t - 1, cnt + 1});
                    }
                }
            }

//            System.out.println(t);
//
//            for (int i = 0; i < H; i++) {
//                System.out.println(Arrays.toString(visit[0][i]));
//            }
//            System.out.println();


        }
    }
}