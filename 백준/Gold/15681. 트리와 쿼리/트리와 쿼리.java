import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, R, Q;
    static int[] arr;
    static List<Integer>[] tree;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        visit = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N + 1; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        visit[R] = true;
        DFS(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num]).append("\n");

        }
        System.out.println(sb);
    }

    private static void DFS(int start) {
        for (Integer next : tree[start]) {
            if(visit[next]) continue;
            visit[next] = true;
            DFS(next);
            arr[start] += arr[next];
        }
    }
}