
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;

    static int[][] map;


    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<Point> q = new LinkedList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    q.add(new Point(i, j, 0));
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        int size = 2;
        int eat = 0;
        while (true) {
            List<Point> fish = new LinkedList<>();
            int[][] distance = new int[N][N];
            while (!q.isEmpty()) {
                Point now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + now.x;
                    int ny = dy[i] + now.y;
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && distance[nx][ny] == 0 && map[nx][ny] <= size) {
                        distance[nx][ny] = distance[now.x][now.y] + 1;
                        q.add(new Point(nx, ny, distance[nx][ny]));
                        if (map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < size) {
                            fish.add(new Point(nx, ny, distance[nx][ny]));
                        }
                    }
                }
            }
            if (fish.size() == 0) {
                System.out.println(time);
                return;
            }

            Point current = fish.get(0);
            for (int i = 1; i < fish.size(); i++) {
                if (current.distance > fish.get(i).distance) {
                    current = fish.get(i);
                } else if (current.distance == fish.get(i).distance) {
                    if (current.x > fish.get(i).x) {
                        current = fish.get(i);
                    } else if (current.x == fish.get(i).x) {
                        if (current.y > fish.get(i).y) {
                            current = fish.get(i);
                        }
                    }
                }
            }
            time += current.distance;
            eat++;
            map[current.x][current.y] = 0;
            if (eat == size) {
                size++;
                eat = 0;
            }
            q.add(new Point(current.x, current.y, 0));
        }
    }


}

class Point {
    int x;
    int y;
    int distance;

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}