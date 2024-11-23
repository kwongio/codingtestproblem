import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            list[b].add(a);
        }
        int min = Integer.MAX_VALUE;
        int person = 0;
        for (int i = 0; i < N; i++) {
            int v = BFS(i);
            if (v < min) {
                min = v;
                person = i;
            }
        }
        System.out.println(person + 1);
    }

    private static int BFS(int start) {
        boolean[] visit = new boolean[N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visit[start] = true;
        q.add(new int[]{start, 0});
        int sum = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int cnt = now[1];
            for (Integer next : list[cur]) {
                if (!visit[next]) {
                    sum += cnt;
                    visit[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }
        return sum;
    }
}