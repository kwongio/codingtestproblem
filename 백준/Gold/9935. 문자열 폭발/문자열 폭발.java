import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        String boom = br.readLine();
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);

            if (stack.size() >= boom.length()) {
                boolean flag = true;
                for (int j = 0; j < boom.length(); j++) {
                    if (boom.charAt(j) != stack.get(stack.size() - boom.length() + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
           sb.append("FRULA");

        }else{
            for (int i = 0; i < stack.size(); i++) {
              sb.append(stack.get(i));
            }
        }
        System.out.println(sb);


    }
}
