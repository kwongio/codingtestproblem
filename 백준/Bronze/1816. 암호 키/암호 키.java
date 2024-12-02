import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Loop :for (int i = 0; i < T; i++) {
            long num = Long.parseLong(br.readLine());
            for (int j = 2; j <= 1_000_000; j++) {
                if (num % j == 0) {
                    System.out.println("NO");
                    continue Loop;
                }
            }
            System.out.println("YES");
        }

    }
}