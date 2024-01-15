import java.io.*;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            Stack<String> stack = new Stack<>();
            String text = br.readLine();
            if (text.equals(".")) {
                return;
            }
            for (String s : text.split("")) {
                if (s.equals("(") || s.equals("[")) {
                    stack.push(s);
                } else if (s.equals(")")) {
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        System.out.println("no");
                        break;
                    }
                } else if (s.equals("]")) {
                    if (!stack.isEmpty()  && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        System.out.println("no");
                        break;
                    }
                } else if (s.equals(".")) {
                    if (stack.isEmpty()) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }
            }
        }


    }

}
