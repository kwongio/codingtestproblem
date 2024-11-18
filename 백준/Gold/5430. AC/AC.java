import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 100
        loop:
        for (int i = 0; i < t; i++) {
            String p = br.readLine(); // 10만
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            ArrayDeque<String> q = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                q.add(st.nextToken());
            }

            boolean flag = true; // true 앞 false 뒤
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    flag = (!flag);
                } else {
                    if (q.isEmpty()) {
                        System.out.println("error");
                        continue loop;
                    }
                    if (flag) {
                        q.pollFirst();
                    } else {
                        q.pollLast();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (q.isEmpty()) {
                System.out.println("[]");
                continue ;
            }


            sb.append("[");
            if (flag) {
                sb.append(q.pollFirst());
                while (!q.isEmpty()) {
                    sb.append(",").append(q.pollFirst());
                }

            } else {
                sb.append(q.pollLast());
                while (!q.isEmpty()) {
                    sb.append(",").append(q.pollLast());
                }
            }
            sb.append("]").append("\n");
            System.out.print(sb);
        }
    }
}