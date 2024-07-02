import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B, C;

    static int[] arr;
    static int[] cost;
    static int start = Integer.MAX_VALUE;
    static int end = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[101];
        cost = new int[3];
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            start = Math.min(start, a);
            end = Math.max(end, b);
            arr[a]++;
            arr[b]--;
        }
        int now = 0;
        for (int i = start; i <= end; i++) {
            now += arr[i];
            arr[i] = now;
        }
        int answer = 0;
        for (int i = start; i <= end; i++) {
            if(arr[i] == 1){
                answer += A * arr[i];
            }else if(arr[i] == 2){
                answer += B * arr[i];
            }else if(arr[i] == 3){
                answer += C * arr[i];
            }
        }
        System.out.println(answer);
    }
}