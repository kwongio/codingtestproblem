import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            boolean vps = vps(s);
            if (vps) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static boolean vps(String s) {
        String[] split = s.split("");
        Stack<String> stack = new Stack<>();
        for (String a : split) {
            if (a.equals("(")) {
                stack.push(a);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

}