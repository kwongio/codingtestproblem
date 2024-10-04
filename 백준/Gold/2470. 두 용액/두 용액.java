import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 0;
        int e = arr.length - 1;
        int[] num = new int[2];
        int min = Integer.MAX_VALUE;
        while (s < e) {
            int v = arr[s] + arr[e];
            int ret = Math.abs(arr[s] + arr[e]);
            if (ret == 0) {
                System.out.println(arr[s] + " " + arr[e]);
                return;
            }
            if (ret < min) {
                min = ret;
                num[0] = arr[s];
                num[1] = arr[e];
            }
            if (v < 0) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(num[0] + " " + num[1]);
    }
}