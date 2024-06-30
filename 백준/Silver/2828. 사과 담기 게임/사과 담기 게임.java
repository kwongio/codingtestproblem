import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int J;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());
        int start = 1;
        int end = M;
        int result = 0;
        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (start > apple) {
                result += start - apple;
                end -= start - apple;
                start = apple;
            } else if (end < apple) {
                start += apple - end;
                result += apple - end;
                end = apple;
            }
        }
        System.out.println(result);

    }
}