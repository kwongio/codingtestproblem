import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N;
    static boolean[] visit;
    static long[] num;
    static char[] oper;
    static long max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N / 2];
        num = new long[N / 2 + N % 2];
        oper = new char[N / 2];

        char[] c = br.readLine().toCharArray();

        int operIdx = 0;
        int numIdx = 0;
        for (int i = 0; i < N; i += 2) {
            num[numIdx++] = c[i] - '0';
        }
        for (int i = 1; i < N; i += 2) {
            oper[operIdx++] = c[i];
        }
        DFS(0, num[0]);
        System.out.println(max);
    }

    private static void DFS(int depth, long sum) {
        if (depth == num.length - 1) {
            max = Math.max(max, sum);
            return;
        }

        DFS(depth + 1, cal(sum, num[depth + 1], oper[depth]));
        if (depth + 2 <= num.length - 1) {
            long ret = cal(num[depth + 1], num[depth + 2], oper[depth + 1]);
            DFS(depth + 2, cal(sum, ret, oper[depth]));
        }
    }

    static long cal(long n1, long n2, char c) {
        if (c == '*') {
            return n1 * n2;
        } else if (c == '-') {
            return n1 - n2;
        } else if (c == '+') {
            return n1 + n2;
        }
        throw new RuntimeException();
    }
}