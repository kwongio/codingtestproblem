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
        int oddIdx = 0;
        String result = "";
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] % 2 == 1) {
                oddCnt++;
                oddIdx = i;
                cnt[i]--;
            }
            if (oddCnt == 2) {
                System.out.println("I'm Sorry Hansoo");
                System.exit(0);
            }
            for (int j = 0; j < cnt[i] / 2; j++) {
                result += (char) (i + 'A');
                result = (char) (i + 'A') + result;
            }
        }
        if (oddCnt == 1) {

            String substring1 = result.substring(0, result.length() / 2);
            String substring = result.substring(result.length() / 2);
            result = substring1;
            result += (char) (oddIdx + 'A');
            result += substring;
        }
        System.out.println(result);
    }
}