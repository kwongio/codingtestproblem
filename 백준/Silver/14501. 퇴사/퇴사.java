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
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        DFS(0, 0);
        System.out.println(max);
    }

    private static void DFS(int day, int money) {
        if (day > N) {
            return;
        }
        if (day == N) {
            max = Math.max(max, money);
            return;
        }

        DFS(day + list.get(day)[0], money + list.get(day)[1]);
        DFS(day + 1, money);
    }

}