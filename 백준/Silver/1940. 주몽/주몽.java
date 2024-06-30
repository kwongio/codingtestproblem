import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M > 200000){
            System.out.println(0);
            return;
        }
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 0;
        int e = N - 1;
        int result = 0;
        while (s < e) {
            if(arr[s] + arr[e] == M){
                result++;
                s++;
                e--;
            }else if(arr[s] + arr[e] < M){
                s++;
            }else{
                e--;
            }
        }
        System.out.println(result);
    }
}