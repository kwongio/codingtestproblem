import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N + 1];
        DFS(0 , 1);


    }

    private static void DFS(int depth, int start) {
        if (M == depth) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                DFS(depth + 1 , i + 1);
                arr[depth] = 0;
                visited[i] = false;
            }
        }

    }

}