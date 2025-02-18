import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 10000;
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(mid)) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(s);
    }

    private static boolean check(int mid) { // mid는 최대값의 최소값
        int e = 0;
        int curMax = Integer.MIN_VALUE;
        int curMin = Integer.MAX_VALUE;
        int cnt = 1;
        while (e < N) {
            curMax = Math.max(curMax, arr[e]); // 현재 구간의 최대값
            curMin = Math.min(curMin, arr[e]); // 현재 구간의 최소값
            if (curMax - curMin > mid) {
                cnt++;
                curMax = arr[e];
                curMin = arr[e];
            }
            e++;
        }
        return cnt <= M;
    }
}
