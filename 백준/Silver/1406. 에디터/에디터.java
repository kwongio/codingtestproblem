import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> ls = new Stack<>();
        Stack<String> rs = new Stack<>();
        for (String temp : br.readLine().split("")) {
            ls.push(temp);
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.equals("L")) {
                if (!ls.isEmpty()) rs.push(ls.pop());
            }
            if (input.equals("D")) {
                if (!rs.isEmpty()) ls.push((rs.pop()));
            }
            if (input.equals("B")) {
                if (!ls.isEmpty()) ls.pop();

            }
            if (input.equals("P")) {
                ls.push(st.nextToken());
            }
        }
        while (!ls.isEmpty()) {
            rs.push(ls.pop());
        }
        while (!rs.isEmpty()) {
            bw.write(rs.pop());
        }
        bw.flush();
    }
}
