import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (!q.isEmpty()) {
                    sb.append(q.poll()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }

            } else if (command.equals("front")) {
                if (!q.isEmpty()) {
                    sb.append(q.peek()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            } else if (command.equals("back")) {
                if (!q.isEmpty()) {
                    sb.append(q.peekLast()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
        
    }
}
