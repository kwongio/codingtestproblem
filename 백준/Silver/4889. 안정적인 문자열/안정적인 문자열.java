import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int round = 1;
        while (true) {
            Stack<String> stack = new Stack<>();

            int answer = 0;
            String str = br.readLine();
            if (str.contains("-")) {
                break;
            }
            String[] split = str.split("");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("{")) {
                    stack.push("{");
                } else {
                    if (stack.isEmpty()) {
                        answer++;
                        stack.push("{");
                    } else {
                        stack.pop();
                    }
                }
            }
            System.out.println(round++ + ". " +( answer + stack.size() / 2));
        }
    }

}