import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static int N;
    static List<Integer> list = new ArrayList<>();
    static int ans = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int num =0 ;
            for (char c : input.toCharArray()) {
                num |= (1 << (c - 'a'));
            }
            list.add(num);
        }
        for (int i = 0; i <= 25; i++) {
            ans |= (1 << i);
        }
        DFS(0, 0);
        System.out.println(cnt);
    }

    private static void DFS(int depth, int a) {
        if (depth == N) {
            if (a == ans) {
                cnt++;
            }
            return;
        }

        DFS(depth + 1, a);
        DFS(depth + 1, a | list.get(depth));
    }
}

