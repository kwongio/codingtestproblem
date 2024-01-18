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
    static int[] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                System.out.println(visited[now] - 1);
                return;
            }

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                q.add(now + 1);
                visited[now + 1] = visited[now] + 1;
            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                q.add(now - 1);
                visited[now - 1] = visited[now] + 1;
            }
            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                q.add(now * 2);
                visited[now * 2] = visited[now] + 1;
            }

        }

    }
}
