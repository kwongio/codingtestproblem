import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> s = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                for (int j = start + 1; j <= value; j++) {
                    sb.append("+").append("\n");
                    s.push(j);
                }
                start = value;
            } else if (s.peek() != value) {
                System.out.println("NO");
                return;
            }
            s.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}