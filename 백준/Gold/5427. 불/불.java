import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int C, R;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int jx, jy;
    static List<int[]> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            fire = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new String[R][C];
            visited = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < C; j++) {
                    map[i][j] = input[j];
                    if (map[i][j].equals("@")) {
                        jx = i;
                        jy = j;
                    } else if (map[i][j].equals("*")) {
                        fire.add(new int[]{i, j});
                    }
                }
            }
            if (!BFS(jx, jy)) {
                System.out.println("IMPOSSIBLE");
            }
        }

    }

    private static boolean BFS(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 1});
        visited[x][y] = true;
        while (true) {
            spread();
            int qSize = q.size();
            while (qSize > 0) {
                qSize--;
                int[] now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + now[0];
                    int ny = dy[i] + now[1];
                    if (nx == -1 || ny == -1 || nx == R || ny == C) {
                        System.out.println(now[2]);
                        return true;
                    }
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny].equals(".")) {
                        visited[nx][ny] = true;
                        map[nx][ny] = "@";
                        q.add(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }
            if (q.isEmpty()) {
                return false;
            }

        }


    }

    private static void spread() {
        List<int[]> temp = new ArrayList<>();
        for (int[] f : fire) {
            for (int i = 0; i < 4; i++) {
                int nx = f[0] + dx[i];
                int ny = f[1] + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && (map[nx][ny].equals(".") || map[nx][ny].equals("@"))) {
                    map[nx][ny] = "*";
                    temp.add(new int[]{nx, ny});
                }
            }
        }
        fire = temp;
    }
}