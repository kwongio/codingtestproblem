import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] operation;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operation = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int depth, long num) {
        if (depth == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                if (i == 0) {
                    DFS(depth + 1, num + arr[depth]);
                } else if (i == 1) {
                    DFS(depth + 1, num - arr[depth]);
                } else if (i == 2) {
                    DFS(depth + 1, num * arr[depth]);
                } else if (i == 3) {
                    DFS(depth + 1, num / arr[depth]);
                }
                operation[i]++;
            }
        }
    }
}