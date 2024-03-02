import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] select;
    static boolean[] visited;
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        select = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(max);


    }

    private static void DFS(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(select[i] - select[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select[depth] = arr[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}