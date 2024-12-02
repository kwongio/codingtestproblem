import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static List<int[]> list;
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        for (int day = 0; day < N ; day++) {
            if (day + list.get(day)[0] > N) {
              
            } else {
                dp[day + list.get(day)[0]] = Math.max(dp[day + list.get(day)[0]], dp[day] + list.get(day)[1]);
            }
            dp[day + 1] = Math.max(dp[day + 1], dp[day]);
        }
        System.out.println(dp[N]);
    }
}