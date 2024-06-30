import java.util.*;
import java.io.*;


public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cost = new int[3 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 3; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[101];
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            start = Math.min(start, s);
            end = Math.max(end, e);
            for (int j = s; j < e; j++) {
                arr[j]++;
            }
        }
//        System.out.println(Arrays.toString(arr));
        int result = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > 0) {
                result += cost[arr[i]] * arr[i];
            }
        }
        System.out.println(result);
    }
}