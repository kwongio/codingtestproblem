import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] memo = new int[M];
        int ans = 0;
        arr = br.readLine().toCharArray();
        for (int i = 1; i < M - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;
                if (memo[i + 1] >= N && arr[i - 2 * N + 1] == 'I') {
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}