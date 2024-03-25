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
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int count = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == X) {
                count++;
            }
            if (sum >= X) {
                end--;
            } else if (sum < X) {
                start++;
            }


        }
        System.out.println(count);
    }

}