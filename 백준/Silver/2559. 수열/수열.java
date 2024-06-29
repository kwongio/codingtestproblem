import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int K;
    static int[] preSum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = K;
        int score = 0;
        for (int i = 0; i < e; i++) {
            score += arr[i];
        }

        int max = score;
        while (e < N) {
            score -= arr[s++];
            score += arr[e++];
            max = Math.max(max, score);
        }
        System.out.println(max);
    }
}