import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int s = 1;
        int e = 0;
        int answer = Integer.MAX_VALUE;
        while (s < N) {
            if (arr[s] - arr[e] < M) {
                s++;
            } else if (arr[s] - arr[e] == M) {
                answer = M;
                break;
            } else {
                answer = Math.min(answer, arr[s] - arr[e]);
                e++;
            }
        }
        System.out.println(answer);
    }
}