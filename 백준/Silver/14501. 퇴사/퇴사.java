import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i][0] = a;
            map[i][1] = b;
        }

        DFS(0, 0);
        System.out.println(max);
    }


    private static void DFS(int day, int sum) {
        if (day > N) return;
        max = Math.max(sum, max);
        if (day < N) {
            DFS(day + map[day][0], sum + map[day][1]);
        }
        DFS(day + 1, sum);
    }
}
