import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<int[]> list;
    static List<Integer> distance;
    static int dx;
    static int dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new int[]{a, b});
            }
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());

            System.out.println(BFS(x, y) ? "happy" : "sad");
        }
    }

    private static boolean BFS(int x, int y) {
        boolean[] visited = new boolean[N];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (Math.abs(now[0] - dx) + Math.abs(now[1] - dy) <= 1000) {
                return true;
            }
            for (int i = 0; i < N; i++) {
                int nx = list.get(i)[0];
                int ny = list.get(i)[1];
                if (!visited[i] && Math.abs(nx - now[0]) + Math.abs(ny - now[1]) <= 1000) {
                    visited[i] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}