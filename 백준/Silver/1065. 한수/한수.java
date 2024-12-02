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
        for (int i = 100; i <= T; i++) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;
            if(a - b ==  b - c)
                ans++;
        }
        System.out.println(ans);
    }
}