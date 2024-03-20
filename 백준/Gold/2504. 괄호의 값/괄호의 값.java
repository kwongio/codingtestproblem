import javax.naming.AuthenticationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        int answer = 0;
        int value = 1;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(")) {
                stack.push("(");
                value *= 2;
            } else if (str[i].equals("[")) {
                stack.push("[");
                value *= 3;
            } else if (str[i].equals("]")) {
                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    if (str[i - 1].equals("[")) answer += value;
                    stack.pop();
                    value /= 3;
                } else {
                    System.out.println(0);
                    return;
                }
            } else if (str[i].equals(")")) {
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    if (str[i - 1].equals("(")) answer += value;
                    stack.pop();
                    value /= 2;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}