import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int x1, x2, y1, y2;
    static int N, M;
    static char[][] map;
    static boolean[][][][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M][N][M];
        boolean check = false;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'o') {
                    if (check) {
                        x1 = i;
                        y1 = j;
                    } else {
                        check = true;
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }
        DFS(x1, y1, x2, y2, 1);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void DFS(int x1, int y1, int x2, int y2, int count) {
        if (count > 10) return;
        for (int i = 0; i < 4; i++) {
            int nx1 = dx[i] + x1;
            int ny1 = dy[i] + y1;
            int nx2 = dx[i] + x2;
            int ny2 = dy[i] + y2;
            if (!isRange(nx1, ny1) && isRange(nx2, ny2)) {
                min = Math.min(count, min);
            } else if (isRange(nx1, ny1) && !isRange(nx2, ny2)) {
                min = Math.min(count, min);
            } else if (isRange(nx1, ny1) && isRange(nx2, ny2)) {
                if (map[nx1][ny1] == '#') {
                    nx1 = x1;
                    ny1 = y1;
                }
                if (map[nx2][ny2] == '#') {
                    nx2 = x2;
                    ny2 = y2;
                }
                if (!visit[nx1][ny1][nx2][ny2]) {
                    visit[nx1][ny1][nx2][ny2] = true;
                    DFS(nx1, ny1, nx2, ny2, count + 1);
                    visit[nx1][ny1][nx2][ny2] = false;
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}