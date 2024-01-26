import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static int x;
    static int y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int d = 1;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        x = 0;
        y = 0;
        Dice dice = new Dice();


        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < K; i++) {
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                d = (d + 2) % 4;
                nx = dx[d] + x;
                ny = dy[d] + y;
            }
            x = nx;
            y = ny;
            dice.rollDice(d);

            answer += score(nx, ny, map[nx][ny]);
            d = getNextDir(dice.down, map[nx][ny], d);
        }

        System.out.println(answer);

    }

    private static int getNextDir(int bottom, int num, int d) {
        if(bottom > num) {
            return (d+1)%4;
        }
        else if(bottom < num) {
            return (d+3)%4;
        }
        else return d;
    }

    private static int score(int x, int y, int v) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == v && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    count++;

                }
            }
        }
        return count * v;
    }


    static class Dice{
        int up, down, left, right, front, back;
        public Dice() {
            up = 1; down = 6; left = 4; right = 3; front = 5; back = 2;
        }

        public void rollDice(int dir) {
            if(dir == 0) toNorth();
            else if(dir == 1) toEast();
            else if(dir == 2) toSouth();
            else toWest();
        }

        public void toEast() {
            int save = up;
            up = left;
            left = down;
            down = right;
            right = save;
        }

        public void toWest() {
            int save = up;
            up = right;
            right = down;
            down = left;
            left = save;
        }

        public void toNorth() {
            int save = up;
            up = front;
            front = down;
            down = back;
            back = save;
        }

        public void toSouth() {
            int save = up;
            up = back;
            back = down;
            down = front;
            front = save;
        }

//        public void print() {
//            System.out.println("  " + back + "  ");
//            System.out.println(left + " " + up + " " + right);
//            System.out.println("  " + front + "  ");
//        }
    }
}