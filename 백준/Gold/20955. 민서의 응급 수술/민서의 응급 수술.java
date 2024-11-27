import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] list;
    static int[] parent;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
            list[i] = new ArrayList<>();
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        visit = new boolean[N + 1];
        int group = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                BFS(i);
                group++;
            }
        }

        // (M + group - 1) 현재 개수
        System.out.println((group - 1)  + (M + group - 1) - (N - 1));
    }

    private static void BFS(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
    }
}