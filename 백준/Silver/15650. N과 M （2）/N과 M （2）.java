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
        DFS(0, "", 1);


    }

    private static void DFS(int L, String select, int s) {
        if (L == M) {
            System.out.println(select);
            return;
        }

        for (int i = s; i <= N; i++) {
            DFS(L + 1, select + i + " ", i + 1);
        }


    }


}