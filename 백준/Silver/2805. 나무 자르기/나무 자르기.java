import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = Arrays.stream(arr).max().getAsInt();
        long mid;


        while (left < right) {
            mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] - mid > 0){
                    count += (arr[i] - mid);
                }
            }
            if (count < M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
