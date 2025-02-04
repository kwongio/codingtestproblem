import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            long max = Math.max(a, Math.max(b, c));
            long sum = a * a + b * b + c * c - max * max;
            if (sum == max * max) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}