import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        dp = new int[N];
        Arrays.fill(dp, -1);
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        DFS(0);
        System.out.println(dp[0]);
    }

    private static int DFS(int day) {
        if (day > N) {
            return -999999;
        }
        if (day == N) {
            return 0;
        }
        if(dp[day] != -1){
            return dp[day];
        }

        dp[day] = Math.max(DFS(day + list.get(day)[0]) + list.get(day)[1], DFS(day + 1));

        return dp[day];
    }
}