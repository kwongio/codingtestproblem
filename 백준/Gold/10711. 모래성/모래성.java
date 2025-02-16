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

        ArrayDeque<int[]> list = new ArrayDeque<>();
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
        int ans = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            for (int s = 0; s < size; s++) {
                int[] now = list.poll();
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
                            list.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if (!list.isEmpty()) {
                ans++;
            }
            for (int[] now : list) {
                int x = now[0];
                int y = now[1];
                board[x][y] = 0;
            }
        }
        System.out.println(ans);


    }

    private static int getCount(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isRange(nx, ny) && board[nx][ny] == 0) {
                count++;
            }
        }
        return count;
    }


    static boolean isRange(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
