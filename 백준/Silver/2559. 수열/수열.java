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
        preSum = new int[N + 1];
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            preSum[i] = preSum[i - 1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            max = Math.max(preSum[i] - preSum[i - K], max);
        }
        System.out.println(max);

    }
}