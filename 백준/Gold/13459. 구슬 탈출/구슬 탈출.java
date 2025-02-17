import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][][] visit;
    static int[] dx = {-1, 0, 1, 0,};
    static int[] dy = {0, 1, 0, -1};
    static int ex, ey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[11][N][M][N][M];
        int rx = -1, ry = -1;
        int bx = -1, by = -1;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (map[i][j] == 'O') {
                    ex = i;
                    ey = j;
                }
            }
        }
        BFS(rx, ry, bx, by);
        System.out.println(0);
    }

    private static void BFS(int srx, int sry, int sbx, int sby) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{srx, sry, sbx, sby, 0});
        visit[0][srx][sry][sbx][sby] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int rx = now[0];
            int ry = now[1];
            int bx = now[2];
            int by = now[3];
            int cnt = now[4];
            if (cnt >= 11) {
                continue;
            }
            if (bx == ex && by == ey) {
                continue;
            }
            if (rx == ex && ry == ey) {
                System.out.println(1);
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int move = 1;
                int rnx;
                int rny;
                int bnx;
                int bny;
                while (true) {
                    rnx = dx[i] * move + rx;
                    rny = dy[i] * move + ry;
                    if (map[rnx][rny] == '#') {
                        rnx -= dx[i];
                        rny -= dy[i];
                        break;
                    } else if (map[rnx][rny] == 'O') {
                        break;
                    }
                    move++;
                }
                move = 1;
                while (true) {
                    bnx = dx[i] * move + bx;
                    bny = dy[i] * move + by;
                    if (map[bnx][bny] == '#') {
                        bnx -= dx[i];
                        bny -= dy[i];
                        break;
                    } else if (map[bnx][bny] == 'O') {
                        break;
                    }
                    move++;
                }
                if (rnx == bnx && rny == bny) {
                    if (rnx == ex && rny == ey) {
                        continue;
                    }
                    if (i == 0) {
                        if (rx > bx) {
                            rnx += 1;
                        } else {
                            bnx += 1;
                        }
                    } else if (i == 2) {
                        if (rx > bx) {
                            bnx -= 1;
                        } else {
                            rnx -= 1;
                        }
                    } else if (i == 1) {
                        if (ry > by) {
                            bny -= 1;
                        } else {
                            rny -= 1;
                        }
                    } else if (i == 3) {
                        if (ry > by) {
                            rny += 1;
                        } else {
                            bny += 1;
                        }
                    }
                }
                if (rny == 0 || rnx == 0 || bnx == 0 || bny == 0 || rnx >= N - 1 || bnx >= N - 1 || rny >= M - 1 || bny >= M - 1)
                    continue;

                if (!visit[cnt][rnx][rny][bnx][bny]) {
                    visit[cnt][rnx][rny][bnx][bny] = true;
                    q.add(new int[]{rnx, rny, bnx, bny, cnt + 1});
                }
//                System.out.println(rnx + " " + rny + " " + bnx + " " + bny + " " + (cnt + 1));
            }
        }
    }
}
