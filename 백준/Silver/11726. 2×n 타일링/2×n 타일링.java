import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] d = new int[100001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        d[4] = 5;
        for (int i = 3; i <= N; i++) {
            d[i] = (d[i - 1] + d[i - 2])%10007;
        }
        System.out.println(d[N]);
    }
}