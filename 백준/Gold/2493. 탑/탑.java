import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > h) {
                    System.out.print(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();

            }
            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[]{h, i + 1});

        }
    }
}