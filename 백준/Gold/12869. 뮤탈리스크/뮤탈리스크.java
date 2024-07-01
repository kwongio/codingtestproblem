import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int[] health;
    static int min = Integer.MAX_VALUE;
    static int[][][] visit = new int[61][61][61];
    static int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9},
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        health = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        BFS(health[0], health[1], health[2]);

    }

    private static void BFS(int a, int b, int c) {
        visit[a][b][c] = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, b, c});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(visit[0][0][0] > 0) break;
            for (int i = 0; i < attack.length; i++) {
                int na = Math.max(0, now[0] - attack[i][0]);
                int nb = Math.max(0, now[1] - attack[i][1]);
                int nc = Math.max(0, now[2] - attack[i][2]);
                if (visit[na][nb][nc] > 0) continue;
                visit[na][nb][nc] = visit[now[0]][now[1]][now[2]] + 1;
                q.add(new int[]{na, nb, nc});
            }
        }
        System.out.println(visit[0][0][0] - 1);
    }
}