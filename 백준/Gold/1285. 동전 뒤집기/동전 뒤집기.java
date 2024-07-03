import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int pow = (int) Math.pow(2, N);
        arr = new int[pow];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int v = 1;
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'T') {
                    arr[i] |= v;
                }
                v *= 2;
            }
        }
        DFS(0);
        System.out.println(min);
    }

    private static void DFS(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 1; i <= (1 << N - 1); i *= 2) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if ((arr[j] & i) != 0) cnt++;
                }
                sum += Math.min(cnt, N - cnt);
            }
            min = Math.min(sum, min);
            return;
        }
        DFS(depth + 1);
        arr[depth] = ~arr[depth];
        DFS(depth + 1);
    }
}
