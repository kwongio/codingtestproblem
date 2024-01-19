
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;

    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<Tomato> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        q = new LinkedList<>();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = sc.nextInt();
                if (v == 1) {
                    q.add(new Tomato(i, j));
                }
                map[i][j] = v;
            }
        }
        while (!q.isEmpty()) {
            Tomato now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        q.offer(new Tomato(nx, ny));
                        map[nx][ny] = map[now.x][now.y] + 1;
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        if (answer == 1) {
            System.out.println(0);
        } else {
            System.out.println(answer - 1);

        }
    }

}

class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}