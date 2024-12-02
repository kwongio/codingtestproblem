import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int ans = 0;
        if (T <= 99) {
            System.out.println(T);
            return;
        }
        ans = 99;
        Loop: for (int i = 100; i <= T; i++) {
            int num = i;
            int pre = num % 10;
            num /= 10;

            int cur = num % 10;
            num /= 10;
            int diff = pre - cur;

            pre = cur;

            while (num != 0) {
                cur = num % 10;
                num /= 10;

                if (diff != pre - cur) {
                    continue Loop;
                }
                pre = cur;
            }
            ans++;
        }
        System.out.println(ans);
    }
}