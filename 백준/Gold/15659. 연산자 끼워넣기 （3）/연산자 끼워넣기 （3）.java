import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N;
    static int[] num;
    static int[] oper;
    static int[] c;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        c = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int depth) {
        if (depth == N - 1) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            ArrayDeque<Character> operation = new ArrayDeque<>();
            stack.push(num[0]);
            for (int i = 0; i < c.length; i++) {
                if (c[i] == 0) { // 덧셈
                    stack.addLast(num[i + 1]);
                    operation.addLast('+');
                } else if (c[i] == 1) { // 뺄셈
                    stack.addLast(num[i + 1]);
                    operation.addLast('-');
                } else if (c[i] == 2) { // 곱셈
                    stack.addLast(stack.pollLast() * num[i + 1]);
                } else if (c[i] == 3) { // 나눗셈
                    stack.addLast(stack.pollLast() / num[i + 1]);
                }
            }
            int ret = stack.poll();
            while (!stack.isEmpty()) {
                Integer num = stack.poll();
                Character oper = operation.poll();
                if (oper == '+') {
                    ret += num;
                }else{
                    ret -= num;
                }
            }
            max = Math.max(ret, max);
            min = Math.min(ret, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                c[depth] = i;
                DFS(depth + 1);
                oper[i]++;
            }
        }

    }
}
