import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
         st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int s = 0 ;
        int e = N - 1;
        while(s < e){
            int sum = arr[s] + arr[e];
            if(Math.abs(sum) < Math.abs(min)){
                min = sum;
            }
            if(sum == 0){
                break;
            }
            if(sum < 0){
                s++;
            }else{
                e--;
            }
        }
        System.out.println(min);
    }
}

