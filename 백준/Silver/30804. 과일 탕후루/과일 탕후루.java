import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int[] ss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        ss = new int[10];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int kind = 0;
        int count = 0;
        while (s <= e && s < N && e < N) {
            if (kind <= 2) {
                if (ss[arr[e]] == 0) {
                    kind++;
                }
                count++;
                ss[arr[e]]++;
                e++;
            } else {
                if (ss[arr[s]] == 1) {
                    kind--;
                }
                count--;
                ss[arr[s]]--;
                s++;
            }
            if (kind <= 2)
                max = Math.max(max, count);
        }
        System.out.println(max);
    }
}