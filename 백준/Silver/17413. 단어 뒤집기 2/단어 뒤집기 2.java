import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].equals("<")) {
                flag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(inputs[i]);
            } else if (inputs[i].equals(">")) {
                sb.append(inputs[i]);
                flag = false;
            } else if (flag) {
                sb.append(inputs[i]);
            } else if(!flag) {
                if (inputs[i].equals(" ")) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(inputs[i]);
                } else {
                    stack.push(inputs[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);


    }
}
