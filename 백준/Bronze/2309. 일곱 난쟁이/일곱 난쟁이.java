import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 101;
                    arr[j] = 101;
                    Arrays.sort(arr);
                    for (int k = 0; k <7; k++) {
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }
}