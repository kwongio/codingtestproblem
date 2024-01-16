import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        DFS(0, "");


    }

    private static void DFS(int L, String select) {
        if (L == M) {
            System.out.println(select);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(L + 1, select + i + " ");
                visited[i] = false;
            }
        }


    }




}