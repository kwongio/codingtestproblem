import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int RED = 0;
    static int BLUE = 1;
    static int GREEN = 2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[RED][i] = Integer.parseInt(st.nextToken());
            arr[BLUE][i] = Integer.parseInt(st.nextToken());
            arr[GREEN][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            arr[RED][i] += Math.min(arr[BLUE][i - 1], arr[GREEN][i - 1]);
            arr[BLUE][i] += Math.min(arr[RED][i - 1], arr[GREEN][i - 1]);
            arr[GREEN][i] += Math.min(arr[BLUE][i - 1], arr[RED][i - 1]);
        }
        System.out.println(Math.min(Math.min(arr[RED][N - 1], arr[BLUE][N - 1]), arr[GREEN][N - 1]));
    }
}