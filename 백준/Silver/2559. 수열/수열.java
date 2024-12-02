import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] prefix = new int[N + 1];
         st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        prefix[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] += arr[i] + prefix[i - 1];
        }
        // K  - 1= 1


        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            max = Math.max(max, prefix[i] - prefix[i - K]);
        }
        System.out.println(max);
    }
}