import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] board;
    static int sx = 1;
    static int sy = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int d = 1;
    static int time;
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
        }
        q.add(new int[]{sx, sy});
        board[sx][sy] = 2;
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());  //X초 후 C로 방향전환
            char C = st.nextToken().charAt(0);   // L일때 왼쪽  D일때 오른쪽
            for (int j = time; j < X; j++) {
                time++;
                int nx = sx + dx[d];
                int ny = sy + dy[d];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                    if (board[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        board[nx][ny] = 2;
                    } else if (board[nx][ny] == 2) {
                        System.out.println(time);
                        System.exit(0);
                    } else if (board[nx][ny] == 0) {
                        if (!q.isEmpty()) {
                            int[] now = q.poll();
                            board[now[0]][now[1]] = 0;
                        }
                        q.add(new int[]{nx, ny});
                        board[nx][ny] = 2;
                    }
                    sx = nx;
                    sy = ny;
                } else {
                    System.out.println(time);
                    System.exit(0);
                }
            }
            if (C == 'L') {
                d = (d - 1 + 4) % 4;
            } else if (C == 'D') {
                d = (d + 1 + 4) % 4;
            }
        }
        while (true) {
            time++;
            int nx = sx + dx[d];
            int ny = sy + dy[d];
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                if (board[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    board[nx][ny] = 2;
                } else if (board[nx][ny] == 2) {
                    System.out.println(time);
                    System.exit(0);
                } else if (board[nx][ny] == 0) {
                    if (!q.isEmpty()) {
                        int[] now = q.poll();
                        board[now[0]][now[1]] = 0;
                    }
                    q.add(new int[]{nx, ny});
                    board[nx][ny] = 2;
                }
                sx = nx;
                sy = ny;
            } else {
                System.out.println(time);
                System.exit(0);
            }
        }
    }

}

