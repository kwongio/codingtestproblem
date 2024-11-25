import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            for (int j = 0; j < 2; j++) {
                char c1 = st.nextToken().charAt(0);
                if (c1 != '.') {
                    list[c - 'A'].add(c1 - 'A');
                } else {
                    list[c - 'A'].add(-1);
                }
            }
        }
        pre(0);
        System.out.println();
        in(0);
        System.out.println();
        post(0);
    }

    private static void pre(int depth) {
        if (depth != -1) {
            System.out.print((char) (depth + 'A'));
            pre(list[depth].get(0));
            pre(list[depth].get(1));
        }

    }

    private static void in(int depth) {
        if (depth != -1) {
            in(list[depth].get(0));
            System.out.print((char) (depth + 'A'));
            in(list[depth].get(1));

        }
    }

    private static void post(int depth) {
        if (depth != -1) {
            post(list[depth].get(0));
            post(list[depth].get(1));
            System.out.print((char) (depth + 'A'));
        }
    }
}