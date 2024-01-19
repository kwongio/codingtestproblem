import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] map;
    static int[] visited;
    static int N;
    static int M;
    static int[] random = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[101];
        visited = new int[101];
        for (int i = 1; i < 101; i++) {
            map[i] = i;

        }
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= 6; i++) {
                int nx = i + now;
                if (nx < 101 && visited[map[nx]] == 0) {
                    visited[map[nx]] = visited[now] + 1;
                    q.add(map[nx]);
                }
                if (map[nx] == 100) {
                    System.out.println(visited[map[nx]]);
                    return;
                }
            }

        }


    }
}