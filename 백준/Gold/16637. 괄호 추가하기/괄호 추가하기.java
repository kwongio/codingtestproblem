import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        for (int i = 0; i < N; i += 2) {
            num.add(str.charAt(i) - '0');
        }
        for (int i = 1; i < N; i += 2) {
            op.add(str.charAt(i));
        }
//        System.out.println(num);
//        System.out.println(op);

        DFS(0, num.get(0));
        System.out.println(max);
    }

    private static void DFS(int depth, int sum) {
        if (depth == num.size() - 1) {
            max = Math.max(sum, max);
            return;
        }

        DFS(depth + 1, cal(sum, num.get(depth + 1), op.get(depth)));
        if (depth + 2 <= num.size() - 1) {
            int result = cal(num.get(depth + 1), num.get(depth + 2), op.get(depth + 1));
            DFS(depth + 2, cal(sum, result, op.get(depth)));
        }
    }

    public static int cal(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        }
        return 0;
    }
}