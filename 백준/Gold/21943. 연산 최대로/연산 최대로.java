import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, P, Q;
    static int[] x;
    static int max;
    static boolean[] visit;
    static int[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = new int[N];
        visit = new boolean[N];
        select = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken()); // 더하기
        Q = Integer.parseInt(st.nextToken()); // 곱하기

        permutation(0);
        System.out.println(max);
    }

    private static void permutation(int depth) {
        if (depth == N) {
            cal(select);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[depth] = x[i];
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void cal(int[] num) {
        DFS(1, P, Q, 1, num[0], num);
    }

    private static void DFS(int depth, int p, int q, int sum, int cal, int[] num) {
        if (depth == N) {
            max = Math.max(max, cal * sum);
            return;
        }
        if (p > 0) {
            DFS(depth + 1, p - 1, q, sum, cal + num[depth], num);
        }
        if (q > 0) {
            DFS(depth + 1, p, q - 1, sum * cal, num[depth], num);
        }
    }

}