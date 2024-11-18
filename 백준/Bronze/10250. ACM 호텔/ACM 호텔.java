import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); // 높이
            int w = Integer.parseInt(st.nextToken()); // 넓이
            int n = Integer.parseInt(st.nextToken()); // n 번째 어디 배치


            int floor;
            int room;
            if (n % h == 0) {
                room = n / h;
                floor = h;
            } else {
                floor = (n % h);
                room = (n / h) + 1;
            }
            System.out.println(floor * 100 + room);
        }

        // 18 == 6 , 12 == 6  6 == 6
    }
}