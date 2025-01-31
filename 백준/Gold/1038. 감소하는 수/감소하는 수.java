import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    static int N;
    static boolean[] visit = new boolean[10];
    static List<Long> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        DFS(0);
        Collections.sort(list);

        if (N > 1022) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    private static void DFS(int depth) {
        if (depth == 10) {
            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                if (visit[i]) {
                    sb.append(i);
                }
            }
            if (sb.isEmpty())
                return;
            list.add(Long.parseLong(sb.toString()));
            return;
        }
        visit[depth] = true;
        DFS(depth + 1);
        visit[depth] = false;
        DFS(depth + 1);
    }
}