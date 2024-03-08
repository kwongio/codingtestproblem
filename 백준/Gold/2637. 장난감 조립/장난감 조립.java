import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static int[][] map;
    static int[] parts;
    static boolean[] combo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 완제품 번호
        M = Integer.parseInt(br.readLine());
        combo = new boolean[N + 1];
        parts = new int[N + 1];
        indegree = new int[N + 1];
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x를 만들려면
            int y = Integer.parseInt(st.nextToken());//  y개가
            int k = Integer.parseInt(st.nextToken());//  k개 필요
            map[x][y] = k;
            combo[x] = true;
            indegree[y]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                parts[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= N ; i++) {
                if (map[now][i] > 0) {
                    parts[i] += parts[now] * map[now][i];
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (!combo[i]) {
                System.out.println(i  + " " + parts[i]);
            }
        }
    }
}