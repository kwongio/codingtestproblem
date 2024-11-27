import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX = 9999999;
    static int N, M;
    static int[][] arr;
    static int[][] next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        next = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = MAX;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
            next[a][b] = b;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == MAX) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(arr[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 0 || arr[i][j] == MAX) {
                    sb.append(0).append("\n");
                    continue;
                }
                List<Integer> path = new ArrayList<>();
                int st = i;
                while (st != j) {
                    path.add(st);
                    st = next[st][j];
                }
                path.add(j);
                sb.append(path.size());
                for (Integer integer : path) {
                    sb.append(" ").append(integer);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}