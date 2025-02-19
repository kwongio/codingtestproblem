import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[input.charAt(j) - 'A'] += (int) Math.pow(10, input.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int ans = 0;
        int idx = 25;
        int num = 9;
        while (arr[idx] != 0) {
            ans += arr[idx] * num;
            idx--;
            num--;
        }
        System.out.println(ans);
    }
}