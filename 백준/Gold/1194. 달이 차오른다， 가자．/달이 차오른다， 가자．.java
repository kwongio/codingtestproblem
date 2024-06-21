import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] start = new int[2];
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M][1 << 6];
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '0') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        System.out.println(BFS(start[0], start[1]));
    }

    public static int BFS(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0, 0});
        visit[x][y][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                int key = now[3];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != '#' && !visit[nx][ny][key]) {
                    if (Character.isAlphabetic(board[nx][ny])) {
                        if (Character.isLowerCase(board[nx][ny])) {
                            key = key | (1 << (board[nx][ny] - 'a'));
                            if (!visit[nx][ny][key]) {
                                visit[nx][ny][key] = true;
                                q.offer(new int[]{nx, ny, now[2] + 1, key});
                            }
                        } else if (Character.isUpperCase(board[nx][ny]) && (key & (1 << (board[nx][ny] - 'A'))) == (1 << (board[nx][ny] - 'A'))) {
                            visit[nx][ny][key] = true;
                            q.offer(new int[]{nx, ny, now[2] + 1, key});
                        }
                    } else if (board[nx][ny] == '1') {
                        return now[2] + 1;
                    } else {
                        q.offer(new int[]{nx, ny, now[2] + 1, key});
                        visit[nx][ny][key] = true;
                    }
                }
            }
        }
        return -1;
    }
}