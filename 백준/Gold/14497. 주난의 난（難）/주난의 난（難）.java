import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    static char[][] board;
    static boolean[][] visit;

    static int[] me = new int[2];
    static int[] you = new int[2];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visit = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int d = Integer.parseInt(st.nextToken()) - 1;
        me[0] = a;
        me[1] = b;
        you[0] = c;
        you[1] = d;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        BFS(me[0], me[1]);
    }

    private static void BFS(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visit[sx][sy] = true;
        int cost = 0;
        while (!visit[you[0]][you[1]]) {
            cost++;
            ArrayDeque<int[]> temp = new ArrayDeque<>();
            while(!q.isEmpty()){
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        if (board[nx][ny] != '0') {
                            board[nx][ny] = '0';
                            temp.add(new int[]{nx, ny});
                        } else {
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            q = temp;
        }
        System.out.println(cost);
    }
}
