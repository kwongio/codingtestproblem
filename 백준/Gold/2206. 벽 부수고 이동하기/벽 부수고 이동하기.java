import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if(N-1 == 0 && M-1 == 0){
            System.out.print(1);
            System.exit(0);
        }
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visited = new boolean[2][N][M];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        map[0][0] = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[2];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1) {
                        if (now[0] == 0 && !visited[1][nx][ny]) {
                            visited[now[0]][nx][ny] = true;
                            map[nx][ny] = map[now[1]][now[2]] + 1;
                            q.add(new int[]{1, nx, ny});
                        }
                    } else {
                        if (!visited[now[0]][nx][ny]) {
                            visited[now[0]][nx][ny] = true;
                            map[nx][ny] = map[now[1]][now[2]] + 1;
                            q.add(new int[]{now[0], nx, ny});
                        }
                    }
                }
                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(map[nx][ny]);
                    System.exit(0);
                }
            }
        }
        System.out.println(-1);

    }
}