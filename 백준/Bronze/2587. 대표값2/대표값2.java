import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;

        int[] arr = new int[N];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }
        double asDouble = Arrays.stream(arr).average().getAsDouble();
        Arrays.sort(arr);
        System.out.println((int)asDouble);
        System.out.println(arr[2]);


    }

}
