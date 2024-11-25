import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] tree;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        answer = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (Integer next : tree[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    answer[next] = now;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}