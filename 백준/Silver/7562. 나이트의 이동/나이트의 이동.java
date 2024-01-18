import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int T;
    static int K;

    static int[][] map;
    static int[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            visited = new int[N][N];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x1, y1});
            visited[x1][y1] = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if (now[0] == x2 && now[1] == y2) {
                    System.out.println(visited[now[0]][now[1]]);
                    break;

                }
                for (int i = 0; i < 8; i++) {
                    int nx = dx[i] + now[0];
                    int ny = dy[i] + now[1];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }

            }
        }


    }
}
