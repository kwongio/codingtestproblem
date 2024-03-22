import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Stack<Long> stack = new Stack<>();
        long answer = 0;

        for (int i = 0; i < N; i++) {
            long h = Long.parseLong(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(h);
        }

        System.out.println(answer);
    }
}