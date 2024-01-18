import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] list;
    static int count = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (!visited[next]) {
                    count++;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        System.out.println(count);
    }
}
