
import java.util.*;

class Main {

    static int N, M;
    static int[][] map;
    static int[][] copy;

    static List<Point> virus = new ArrayList<>();
    static Queue<Point> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int v = sc.nextInt();
                if (v == 2) {
                    virus.add(new Point(i, j));
                }
                map[i][j] = v;
            }
        }

        DFS(0);
        System.out.println(max);
    }


    private static void DFS(int L) {
        if (L == 3) {
            copy = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copy[i][j] = map[i][j];
                }
            }

            for (Point point : virus) {
                q.add(point);
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = dx[i] + p.x;
                        int ny = dy[i] + p.y;
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if (copy[nx][ny] == 0) {
                                copy[nx][ny] = 2;
                                q.add(new Point(nx, ny));
                            }
                        }
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 0) {
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        } else {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        DFS(L + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}