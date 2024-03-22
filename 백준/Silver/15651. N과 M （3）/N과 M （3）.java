import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static boolean[] visited;
    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        DFS(0, "");
        bw.flush();


    }

    private static void DFS(int L, String select) throws IOException {
        if (L == M) {
            bw.write(select + "\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            DFS(L + 1, select + i + " ");
        }


    }


}