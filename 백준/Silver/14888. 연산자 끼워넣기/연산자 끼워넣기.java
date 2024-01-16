import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N;
    static int[] operation;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        operation = new int[4];
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

    private static void DFS(int depth, int sum) {
        if (depth == N) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                if (i == 0) DFS(depth + 1, sum + arr[depth]);
                if (i == 1) DFS(depth + 1, sum - arr[depth]);
                if (i == 2) DFS(depth + 1, sum * arr[depth]);
                if (i == 3) DFS(depth + 1, sum / arr[depth]);
                operation[i]++;
            }
        }


    }

}