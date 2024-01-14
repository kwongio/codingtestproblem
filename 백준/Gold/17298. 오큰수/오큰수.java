import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                numbers[s.pop()] = numbers[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            numbers[s.pop()] = -1;
        }
        for (int i = 0; i < N; i++) {
            sb.append(numbers[i]).append(" ");
        }
        System.out.println(sb);

    }
}
