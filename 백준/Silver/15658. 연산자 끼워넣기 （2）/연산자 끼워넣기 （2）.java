import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N;
    static int[] num;
    static int[] oper;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                if (i == 0) {
                    DFS(depth + 1, sum + num[depth]);
                } else if (i == 1) {
                    DFS(depth + 1, sum - num[depth]);
                } else if (i == 2) {
                    DFS(depth + 1, sum * num[depth]);
                } else {
                    DFS(depth + 1, sum / num[depth]);
                }
                oper[i]++;
            }
        }
    }
}
