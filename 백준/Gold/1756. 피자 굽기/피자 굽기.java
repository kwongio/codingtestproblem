import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int D, N;
    static long[] arr;
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[D + 1];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= D; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            arr[i] = Math.min(arr[i], arr[i - 1]);
        }
        depth = D + 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pizza = Integer.parseInt(st.nextToken());
            search(pizza);

        }
        System.out.println(depth);
    }

    private static void search(int target) {
        int start = 0;
        int end = depth - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                depth = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

    }


}