import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'] = str.indexOf(str.charAt((i)));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}