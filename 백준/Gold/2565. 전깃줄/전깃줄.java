import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        dp = new int[N + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        list.sort(Comparator.comparing(o -> o[0]));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i)[1] > list.get(j)[1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        System.out.println(N - Arrays.stream(dp).max().getAsInt());
    }
}