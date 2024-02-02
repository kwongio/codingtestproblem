import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    static int[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Group> groups = new ArrayList<>();
    static boolean[][] visited;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        BFS(i, j, map[i][j]);
                    }
                }
            }
            if (groups.isEmpty()) {
                break;
            }
            groups.sort((o1, o2) -> {
                if (o1.count == o2.count) {
                    if (o2.rainbow == o1.rainbow) {
                        if (o1.x == o2.x) {
                            return o2.y - o1.y;
                        }
                        return o2.x - o1.x;
                    }
                    return o2.rainbow - o1.rainbow;
                }
                return o2.count - o1.count;
            });

            //groups 제거
            remove(groups.get(0));
            gravity();
            rotate();
            gravity();


        }
        System.out.println(answer);

    }

    private static void rotate() {
        int[][] temp = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                temp[i][j] = map[j][N-i-1];
            }
        }
        map = temp;
    }

    private static void gravity() {
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 1; j--) {
                if (map[j][i] != -2) continue;
                int nx = j;
                while (true) {
                    nx -= 1;
                    if (nx < 0) break;
                    if (map[nx][i] == -1) break;
                    if (map[nx][i] != -2) {
                        map[j][i] = map[nx][i];
                        map[nx][i] = -2;
                        break;
                    }
                }
            }
        }

    }

    private static void remove(Group group) {
        answer += group.count * group.count;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{group.x, group.y});
        map[group.x][group.y] = -2;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (map[nx][ny] == group.color || map[nx][ny] == 0) {
                    map[nx][ny] = -2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        groups.clear();
    }

    private static void BFS(int x, int y, int color) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int rainbow = 0;
        int colorCount = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if (map[nx][ny] == 0 || map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    colorCount++;
                    if (map[nx][ny] == 0) rainbow++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = false;
                }
            }
        }
        if (colorCount == 1) {
            return;
        }
        groups.add(new Group(color, x, y, colorCount, rainbow));
    }

    static class Group {
        int color;
        int x;
        int y;
        int count;
        int rainbow;

        public Group(int color, int x, int y, int count, int rainbow) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.count = count;
            this.rainbow = rainbow;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "color=" + color +
                    ", x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    ", rainbow=" + rainbow +
                    '}';
        }
    }

}
