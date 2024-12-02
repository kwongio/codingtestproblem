import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100 ; j++) {
                for (int k = 1; k <= 100 ; k++) {
                    if ((i + j + k == N) && (i >= j + 2) && (i != 0 && j != 0 && k != 0) && k % 2 == 0) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}