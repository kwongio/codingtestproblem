import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
        System.out.println(result);
    }

    private static void DFS(int L, int idx) {
        if (L == N / 2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        start += map[i][j] + map[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += map[i][j] + map[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(start - link));
            if (result == 0) {
                System.out.println(result);
                System.exit(0);
            }

            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(L + 1, i + 1);
                visited[i] = false;
            }
        }

    }

}