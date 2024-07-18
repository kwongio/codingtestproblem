import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C, M;

    static int[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int sy = -1;
    static int sum = 0;
    static int[][] cnt;
    static Map<Integer, int[]> shark = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // r x
            int c = Integer.parseInt(st.nextToken()) - 1; // c y
            int s = Integer.parseInt(st.nextToken()); // s 속력
            int d = Integer.parseInt(st.nextToken()); // d 방향
            if (d == 1) d = 0; //위
            else if (d == 2) d = 2; // 아래
            else if (d == 3) d = 3; // 오른쪽
            else if (d == 4) d = 1;// 왼족
            int z = Integer.parseInt(st.nextToken()); // z 크기
            shark.put(z, new int[]{r, c, s, d});
            board[r][c] = z;
        }
        while (sy != C - 1) {
            sy++;
            removeShark();
            moveShark();
        }
        System.out.println(sum);
    }

    private static void moveShark() {
        cnt = new int[R][C];
        int[][] tempBoard = new int[R][C];
        Map<Integer, int[]> tempMap = new HashMap<>();
        for (int i : shark.keySet()) {
            int[] info = shark.get(i);
            int r = info[0];
            int c = info[1];
            int s = info[2];
            int d = info[3];
            int z = board[r][c];
            if (d == 0 || d == 2) {
                s %= (2 * (R - 1));
            } else {
                s %= (2 * (C - 1));
            }
            int nx = r;
            int ny = c;
            for (int j = 0; j < s; j++) {
                nx = dx[d] + r;
                ny = dy[d] + c;
                if (nx < 0 || nx >= R || ny < 0 | ny >= C) {
                    d = (d + 2) % 4;
                    nx = dx[d] + r;
                    ny = dy[d] + c;
                }
                r = nx;
                c = ny;
            }

            if (cnt[nx][ny] == 1) {
                if (tempBoard[nx][ny] < z) {
                    tempMap.remove(tempBoard[nx][ny]);
                    tempBoard[nx][ny] = z;
                    tempMap.put(z, new int[]{r, c, s, d});
                }
            } else {
                cnt[nx][ny]++;
                tempBoard[nx][ny] = z; // 크기로 설정
                tempMap.put(z, new int[]{r, c, s, d});
            }
        }
        shark = new HashMap<>(tempMap);
        for (int i = 0; i < R; i++) {
            board[i] = Arrays.copyOf(tempBoard[i], tempBoard[i].length);
        }
    }

    private static void removeShark() {
        for (int i = 0; i < R; i++) {
            if (board[i][sy] > 0) {
                sum += board[i][sy];
                shark.remove(board[i][sy]);
                board[i][sy] = 0;
                break;
            }
        }
    }
}



