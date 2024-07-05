import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        Arrays.sort(arr, (o1, o2) -> Long.compare(o1[0], o2[0]));
        int v;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][1] <= idx) continue;
            if (idx < arr[i][0]) {
                v = (arr[i][1] - arr[i][0]) / L;
                if ((arr[i][1] - arr[i][0]) % L > 0) {
                    v++;
                }
                idx = arr[i][0] + v * L;
            } else {
                v = (arr[i][1] - idx) / L;
                if((arr[i][1] - idx) % L > 0){
                    v++;
                }
                idx = idx + v * L;
            }
            answer += v;
        }
        System.out.print(answer);
    }
}