import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int D, N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[D + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= D; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 1; i < D; i++) {
            if (arr[i] < arr[i + 1]) {
                arr[i + 1] = arr[i];
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pizza = Integer.parseInt(st.nextToken());
            while (D >= 0 && pizza > arr[D--]) ;
        }
        System.out.println(D + 1);
    }

    private static void search(int target) {
        int start = 0;
        int end = D - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                mid = end - 1;
            } else if (arr[mid] < target) {
                mid = start + 1;
            }
        }
        D = mid - 1;
    }
}