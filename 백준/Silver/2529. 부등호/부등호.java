import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[] arr;
    static boolean[] visit = new boolean[10];
    static String min = "99999999999";
    static String max = "-9999999999";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            char c = st.nextToken().charAt(0);
            arr[i] = c;
        }
        for (int i = 0; i <= 9; i++) {
            visit[i] = true;
            DFS(0, String.valueOf(i));
            visit[i] = false;
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int depth, String answer) {
        if (depth == N) {
            if (answer.compareTo(max) >= 0) max = answer;
            if (answer.compareTo(min) <= 0) min = answer;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visit[i] && check(i, arr[depth], answer)) {
                visit[i] = true;
                DFS(depth + 1, answer + i);
                visit[i] = false;
            }
        }
    }

    private static boolean check(int num, char c, String answer) {
        long a = (answer.charAt(answer.length() - 1) - '0');
        if (c == '>') {
            return a > num;
        } else if (c == '<') {
            return a < num;
        }
        return false;
    }
}