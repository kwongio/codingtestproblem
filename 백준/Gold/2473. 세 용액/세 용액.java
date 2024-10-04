import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long[] num = new long[3];
        for (int i = 0; i < N; i++) {
            int s = i + 1;
            int e = N - 1;
            while(s < e){
//                if(s == i){
//                    s++;
//                    continue;
//                }
//
//                if(e == i){
//                    e--;
//                    continue;
//                }

                long v = arr[i] + arr[s] + arr[e];
                long ret = Math.abs(arr[i] + arr[s] + arr[e]);
                if(ret < min){
                    min = ret;
                    num[0] = arr[i];
                    num[1] = arr[s];
                    num[2] = arr[e];
                }
                if(v > 0){
                    e--;
                }else {
                    s++;
                }
            }
        }
        Arrays.sort(num);
        for (long i : num) {
            System.out.print(i + " ");
        }
    }
}