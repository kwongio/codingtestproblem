import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] open;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static List<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;

        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = BFS(i, j);
                        if (list.size() > 1) {
                            isMove = true;
                            int avg = sum / list.size();
                            for (int[] now : list) {
                                map[now[0]][now[1]] = avg;
                            }
                        }

                    }
                }
            }
            if (!isMove) {
                System.out.println(result);
                System.exit(0);
            }
            result++;

        }
    }

    private static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = map[x][y];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[now[0]][now[1]] - map[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.add(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return sum;
    }
}