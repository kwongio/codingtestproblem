import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] arr;
    static int[] count;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[4001][4001];
        count = new int[4001];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = true;
            arr[b][a] = true;
            count[a]++;
            count[b]++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (!arr[i][j]) continue;
                for (int k = j + 1; k < N; k++) {
                    if (!arr[i][k] || !arr[j][k]) continue;
                    int sum = count[i] + count[j] + count[k] - 6;
                    min = Math.min(min, sum);
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
