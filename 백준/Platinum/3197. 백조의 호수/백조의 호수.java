import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][] visit;
    static boolean[][] sVitit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayDeque<int[]> swan = new ArrayDeque<>();
    static ArrayDeque<int[]> water = new ArrayDeque<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visit = new boolean[N][M];
        sVitit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (swan.isEmpty() && board[i][j] == 'L') {
                    swan.add(new int[]{i, j});
                    sVitit[i][j] = true;
                }
                if (board[i][j] == '.' || board[i][j] == 'L') {
                    water.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        BFS();
    }

    private static void BFS() {

        int day = 0;
        while (true) {
            if (move()) {
                System.out.println(day);
                System.exit(0);
            }
            day++;
            ArrayDeque<int[]> temp = new ArrayDeque<>();
            while (!water.isEmpty()) {
                int[] now = water.poll();
                int x = now[0];
                int y = now[1];
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        if (board[nx][ny] == 'X') {
                            temp.offer(new int[]{nx, ny});
                            board[nx][ny] = '.';
                        } else if (board[nx][ny] == '.') {
                            water.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            water = temp;
        }
    }

    private static boolean move() {
        ArrayDeque<int[]> temp = new ArrayDeque<>();
        while (!swan.isEmpty()) {
            int[] now = swan.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !sVitit[nx][ny]) {
                    sVitit[nx][ny] = true;
                    if (board[nx][ny] == '.') {
                        swan.offer(new int[]{nx, ny});
                    } else if (board[nx][ny] == 'X') {
                        temp.offer(new int[]{nx, ny});
                    } else if (board[nx][ny] == 'L') {
                        return true;
                    }
                }
            }
        }
        swan = temp;
        return false;
    }
}