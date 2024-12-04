import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str = br.readLine();
        Stack<Character> a = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                a.push(c);
            } else if (c == ')') {
                while (!a.isEmpty() && a.peek() != '(') {
                    System.out.print(a.pop());
                }
                if (!a.isEmpty()) {
                    a.pop();
                }
            } else if (c == '+' || c == '/' || c == '*' || c == '-') {
                while (!a.isEmpty() && precedence(a.peek()) >= precedence(c)) {
                    System.out.print(a.pop());
                }
                a.push(c);
            } else {
                System.out.print(c);
            }
        }
        while (!a.isEmpty()) {
            System.out.print(a.pop());
        }
    }

    public static int precedence(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}
