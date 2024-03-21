import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, R, C;
    static String[][][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int sx, sy, sz, ex, ey, ez;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             L = Integer.parseInt(st.nextToken());
             R = Integer.parseInt(st.nextToken());
             C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            map = new String[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] str = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str[k];
                        if (map[i][j][k].equals("S")) {
                            sz = i;
                            sx = j;
                            sy = k;
                        } else if (map[i][j][k].equals("E")) {
                            ez = i;
                            ex = j;
                            ey = k;
                        }
                    }
                }
                br.readLine();
            }

            if (!BFS(sz, sx, sy)) {
                System.out.println("Trapped!");
            }
        }
    }

    private static boolean BFS(int z, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{z, x, y, 0});
        visited[z][x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == ez && now[1] == ex && now[2] == ey) {
                System.out.println("Escaped in " + now[3] + " minute(s).");
                return true;
            }
            for (int i = 0; i < 6; i++) {
                int nz = dz[i] + now[0];
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[2];

//                System.out.println(nz + " " + nx + " " + ny);
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L && (map[nz][nx][ny].equals(".") || map[nz][nx][ny].equals("E")) && !visited[nz][nx][ny]) {
//                    System.out.println(nz + " " + nx + " " + ny);
                    visited[nz][nx][ny] = true;
                    q.add(new int[]{nz, nx, ny, now[3] + 1});
                }
            }
        }
        return false;
    }

}