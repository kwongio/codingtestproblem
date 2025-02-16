import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static int H, W;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new int[H][W];

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = input.charAt(j);
                if (c == '.') {
                    list.add(new int[]{i, j});
                    board[i][j] = 0;
                } else {
                    board[i][j] = c - '0';
                }
            }
        }
        visit = new boolean[H][W];
        List<int[]> next = new ArrayList<>();

        int ans = 0;
        while (!list.isEmpty()) {
//            for (int i = 0; i < H; i++) {
//                System.out.println(Arrays.toString(board[i]));
//            }
//            System.out.println();
            //다음 점 찾기
            for (int[] now : list) {
                int x = now[0];
                int y = now[1];
                visit[x][y] = true;
                for (int i = 0; i < 8; i++) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    if (isRange(nx, ny) && !visit[nx][ny] && board[nx][ny] != 0 && board[nx][ny] != 9) {
                        int count = getCount(nx, ny);
                        if (count >= board[nx][ny]) {
                            visit[nx][ny] = true;
                            next.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if (!next.isEmpty()) {
                ans++;
            }
            list.clear();
            for (int[] now : next) {
                int x = now[0];
                int y = now[1];
                list.add(new int[]{x, y});
                board[x][y] = 0;
            }
            next.clear();
        }
        System.out.println(ans);


    }

    private static int getCount(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isRange(nx, ny) && board[nx][ny] == 0) {
                cnt++;
            }
        }
        return cnt;
    }


    static boolean isRange(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
