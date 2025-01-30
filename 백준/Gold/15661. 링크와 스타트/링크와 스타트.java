import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        DFS(0, 0);
        System.out.println(min);
    }

    private static void DFS(int depth, int count) {
        if (depth == N) {
            if (count == 0) {
                return;
            }
            int a = 0;
            int b = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] && visit[j]) {
                        a += map[i][j] + map[j][i];
                    } else if (!visit[i] && !visit[j]) {
                        b += map[i][j] + map[j][i];
                    }
                }
            }
            min = Math.min(Math.abs(a - b), min);
            if (min == 0) {
                System.out.println(0);
                System.exit(0);
            }

            return;
        }

        visit[depth] = true;
        DFS(depth + 1, count + 1);
        visit[depth] = false;
        DFS(depth + 1, count);

    }
}
