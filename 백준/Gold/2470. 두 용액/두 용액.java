import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] answer = new long[2];
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            long sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[start];
                answer[1] = arr[end];
                if (sum == 0) {
                    break;
                }
            }
            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

}