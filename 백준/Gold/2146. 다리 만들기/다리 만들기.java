import java.util.*;

class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    static int num = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    landNum(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    visited = new boolean[N][N];
                    makeBridge(i, j);
                }
            }
        }
        System.out.println(answer);


    }

    private static void makeBridge(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j, 0));
        int currNum = map[i][j];
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != currNum && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        q.offer(new Point(nx, ny, now.cnt + 1));
                    } else {
                        answer = Math.min(answer, now.cnt);
                    }
                }
            }
        }
    }

    private static void landNum(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j, 0));
        map[i][j] = num;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1) {
                    map[nx][ny] = num;
                    q.add(new Point(nx, ny, 0));
                }
            }
        }
        num++;
    }
}

class Point {
    int x;
    int y;
    int cnt;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}