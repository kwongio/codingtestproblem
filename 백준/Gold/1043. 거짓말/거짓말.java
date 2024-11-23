import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static int N, M;
    static boolean[] know;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // (N + 1)/2 이상인 것은 중간이 될 수 없다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        know = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());

        int person = Integer.parseInt(st.nextToken());
        for (int i = 0; i < person; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        List<Integer>[] party = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            party[i].add(pre);
            for (int j = 1; j < size; j++) {
                int next = Integer.parseInt(st.nextToken());
                party[i].add(next);
                list[pre].add(next);
                list[next].add(pre);
            }
        }
        BFS();
        int ans = 0;
        Loop: for (int i = 0; i < M; i++) {
            for (Integer p : party[i]) {
                if (know[p]) {
                    continue Loop;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }

    private static void BFS() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (know[i]) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (Integer i : list[now]) {
                if (!know[i]) {
                    know[i] = true;
                    q.add(i);
                }
            }
        }
    }
}