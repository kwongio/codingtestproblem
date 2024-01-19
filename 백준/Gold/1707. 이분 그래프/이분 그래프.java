import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<List<Integer>> list;
    static int[] color;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            color = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(start).add(end);
                list.get(end).add(start);
            }
            boolean flag = false;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0)
                    flag = bfs(i , 1);
                if(!flag) break;
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int start, int colors) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = colors;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list.get(now)) {
                if (color[now] == color[next]) {
                    return false;
                }
                if (color[next] == 0) {
                    color[next] = color[now] * -1;
                    q.add(next);
                }
            }
        }
        return true;
    }
}