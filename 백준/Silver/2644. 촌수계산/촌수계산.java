import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        List<Integer>[] list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{num1, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == num2) {
                System.out.println(now[1]);
                System.exit(0);
            }
            if (visited[now[0]]) continue;

            for (int next : list[now[0]]) {
                if (!visited[next]) {
                    visited[now[0]] = true;
                    queue.add(new int[]{next, now[1] + 1});
                }
            }
        }
        System.out.println(-1);
    }
}