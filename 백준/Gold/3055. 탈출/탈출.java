import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int R;
    static int C;
    static char[][] board;
    static int[] gosum = new int[2];
    static int[] end = new int[2];
    static ArrayDeque<int[]> water = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '*') {
                    water.offer(new int[]{i, j});
                } else if (board[i][j] == 'S') {
                    gosum[0] = i;
                    gosum[1] = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'D') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int result = BFS(gosum[0], gosum[1]);
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static int BFS(int sx, int sy) {
        boolean[][] visit = new boolean[R][C];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visit[sx][sy] = true;
        while (!q.isEmpty()) {
            int len = water.size();
            for (int i = 0; i < len; i++) {
                int[] now = water.poll();
                int x = now[0];
                int y = now[1];
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x;
                    int ny = dy[j] + y;
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] == '.') {
                        water.offer(new int[]{nx, ny});
                        board[nx][ny] = '*';
                    }
                }
            }

            len = q.size();
            for (int j = 0; j < len; j++) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                int move = now[2];
                if (x == end[0] && y == end[1]) {
                    return move;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visit[nx][ny] && (board[nx][ny] == '.' || board[nx][ny] == 'D')) {
                        q.add(new int[]{nx, ny, move + 1});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}