import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N = 100;
    static boolean[][] visited = new boolean[N + 1][N + 1];

    static int paper = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j < a + paper; j++) {
                for (int k = b; k < b + paper; k++) {
                    if (!visited[j][k]) {
                        visited[j][k] = true;
                        count++;
                    }

                }
            }
        }
        System.out.println(count);
    }


}