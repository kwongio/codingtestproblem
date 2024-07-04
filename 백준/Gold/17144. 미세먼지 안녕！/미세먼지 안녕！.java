import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static int T;

    static int[][] board;

    static int up;
    static int down;
    static int[] dx = {1, -1, 0, 0};

    static int[] dy = {0, 0, 1, -1};

    static List<int[]> dust = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[R][C];


        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] >= 1) {
                    dust.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < R; i++) {
            if (board[i][0] == -1) {
                up = i;
                down = i + 1;
                break;
            }
        }
        while (T > 0) {
            answer = 0;
            spread();
            air();
            dust.clear();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] >= 1) {
                        dust.add(new int[]{i, j});
                        answer += board[i][j];
                    }
                }
            }
            T--;
        }

        System.out.println(answer);
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static void air() {
        for (int i = up - 1; i > 0; i--) {
            board[i][0] = board[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            board[0][i] = board[0][i + 1];
        }
        for (int i = 0; i < up; i++) {
            board[i][C - 1] = board[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            board[up][i] = board[up][i - 1];
        }
        board[up][1] = 0;


        for (int i = down + 1; i < R - 1; i++) {
            board[i][0] = board[i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            board[R - 1][i] = board[R - 1][i + 1];
        }

        for (int i = R - 1; i > down; i--) {
            board[i][C - 1] = board[i - 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            board[down][i] = board[down][i - 1];
        }
        board[down][1] = 0;
    }

    private static void spread() {
        int[][] temp = new int[R][C];
        for (int[] d : dust) {
            int count = 0;
            int x = d[0];
            int y = d[1];
            int cost = board[x][y] / 5;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] != -1) {
                    count++;
                    temp[nx][ny] += cost;
                }
            }
            temp[x][y] += board[x][y] - cost * count;
        }

        for (int i = 0; i < R; i++) {
            board[i] = Arrays.copyOf(temp[i], temp[0].length);
        }
        board[up][0] = -1;
        board[down][0] = -1;
    }
}