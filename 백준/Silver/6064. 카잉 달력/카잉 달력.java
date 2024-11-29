import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int T;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / GCD(M, N);
            x--;
            y--;
            int year =x ;
            while (year <= lcm) {
                if (year % N == y) {
                    System.out.println(year + 1);
                    break;
                }
                year += M;
            }
            if (year > lcm) {
                System.out.println(-1);
            }
        }
    }

    private static int GCD(int m, int n) {
        if (m % n == 0) {
            return n;
        }

        return GCD(n, m % n);
    }
}