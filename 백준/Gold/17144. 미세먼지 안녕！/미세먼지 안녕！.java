import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int R, C, T;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[] dy2 = {1, 0, -1, 0};
    static int[] dx2 = {0, 1, 0, -1};
    static List<int[]> list = new ArrayList<>();
    static List<int[]> up = new ArrayList<>();
    static List<int[]> down = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        boolean flag = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            if (board[i][0] == -1) {
                if (!flag) {
                    up = chuck(i, 0, dx, dy);
                    flag = true;
                } else {
                    down = chuck(i, 0, dx2, dy2);
                }
            }
        }
        for (int i = 0; i < T; i++) {
            pushDusk();
            spread();
            clean();
        }
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != -1) {
                    answer += board[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    private static void clean() {
        for (int i = up.size() - 1; i > 0; i--) {
            int[] now = up.get(i);
            int[] next = up.get(i - 1);
            board[now[0]][now[1]] = board[next[0]][next[1]];
        }
        int[] d = up.get(0);
        board[d[0]][d[1]] = 0;

        for (int i = down.size() - 1; i > 0; i--) {
            int[] now = down.get(i);
            int[] next = down.get(i - 1);
            board[now[0]][now[1]] = board[next[0]][next[1]];
        }
        int[] d2 = down.get(0);
        board[d2[0]][d2[1]] = 0;
    }

    private static List<int[]> chuck(int sx, int sy, int[] dx, int[] dy) {
        List<int[]> temp = new ArrayList<>();
        int x = sx;
        int y = sy;
        int cnt = 0;
        while (true) {
            int nx = x + dx[cnt];
            int ny = y + dy[cnt];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                cnt++;
                if (cnt >= dx.length) {
                    break;
                }
                nx = x + dx[cnt];
                ny = y + dy[cnt];
            }
            if (sx == nx && sy == ny) break;
            x = nx;
            y = ny;
            temp.add(new int[]{nx, ny});
        }
        return temp;
    }

    private static void pushDusk() {
        list.clear();  // 매 반복마다 list를 초기화해야 함
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
    }

    private static void spread() {
        int[][] temp = new int[R][C];
        for (int[] dusk : list) {
            int x = dusk[0];
            int y = dusk[1];
            int value = board[x][y] / 5;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] != -1) {
                    temp[nx][ny] += value;
                    board[x][y] -= value;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] += temp[i][j];
            }
        }
    }
}