import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] list;
    static int N;
    static int count = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }
        DFS(V);
        visited = new boolean[N + 1];
        System.out.println();
        BFS(V);
    }

    private static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        System.out.print(v + " ");
        visited[v] = true;
        for (int next : list[v]) {
            DFS(next);
        }
    }

    private static void BFS(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int next : list[now])
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
        }
    }
}
