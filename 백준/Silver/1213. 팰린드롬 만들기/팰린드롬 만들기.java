import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] cnt = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i] - 'A']++;
        }
        int oddCnt = 0;
        int mid = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] % 2 == 1) {
                oddCnt++;
                mid = i;
                cnt[i]--;
            }
            if (oddCnt == 2) {
                System.out.println("I'm Sorry Hansoo");
                System.exit(0);
            }
            for (int j = 0; j < cnt[i] / 2; j++) {
                result.append((char) (i + 'A'));
                result.insert(0, (char) (i + 'A'));
            }
        }
        if (oddCnt == 1)
            result.insert(result.length() / 2, (char) (mid + 'A'));
        System.out.println(result);
    }
}