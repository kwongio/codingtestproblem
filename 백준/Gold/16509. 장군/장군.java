import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;

class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dx1 = {1, 1, -1, -1, -1, 1, -1, 1};
    static int[] dy1 = {-1, 1, -1, 1, 1, 1, -1, -1};

    static int sx, sy, ex, ey;
    static int N = 10;
    static int M = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());


        boolean[][] visit = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, 0});
        visit[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            if (x == ex && y == ey) {
                System.out.println(cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (isRange(nx, ny) && !(nx == ex && ny == ey)) {
                    for (int j = i * 2; j < i * 2 + 2; j++) {
                        int nx1 = dx1[j] + nx;
                        int ny1 = dy1[j] + ny;
                        int nx2 = dx1[j] * 2 + nx;
                        int ny2 = dy1[j] * 2 + ny;
                        if (isRange(nx1, ny1) && isRange(nx2, ny2) && !visit[nx2][ny2] && !(nx1 == ex && ny1 == ey) ) {
                            visit[nx2][ny2] = true;
                            q.add(new int[]{nx2, ny2, cnt + 1});
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}