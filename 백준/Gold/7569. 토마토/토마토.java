import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][][] map;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if (map[h][i][j] == 1) {
                        q.add(new int[]{h, i, j});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nz = dz[i] + now[0];
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[2];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if (map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = map[now[0]][now[1]][now[2]] + 1;
                        q.add(new int[]{nz, nx, ny});
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    max = Math.max(max, map[h][i][j]);
                    if (map[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if (max == 1) {
            System.out.println(0);

        } else {

            System.out.println(max - 1);
        }
    }
}