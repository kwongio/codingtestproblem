import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static int T;
    static int a, b;
    static char[] cmd = {'D', 'S', 'L', 'R'};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ArrayDeque<Node> q = new ArrayDeque<>();
            boolean[] visit = new boolean[10000];
            visit[a] = true;
            q.add(new Node(a, ""));
            while (!q.isEmpty()) {
                Node now = q.poll();
                int num = now.num;
                String command = now.cmd;
                if (num == b) {
                    sb.append(command).append("\n");
                    break;
                }
                int d = (num * 2) % 10000;
                int s = num == 0 ? 9999 : num - 1;
                int l = (num % 1000 * 10) + num / 1000;
                int r = (num % 10 * 1000) + num / 10;
                if (!visit[d]) {
                    visit[d] = true;
                    q.add(new Node(d, command + 'D'));
                }
                if (!visit[s]) {
                    visit[s] = true;
                    q.add(new Node(s, command + 'S'));
                }
                if (!visit[l]) {
                    visit[l] = true;
                    q.add(new Node(l, command + 'L'));
                }
                if (!visit[r]) {
                    visit[r] = true;
                    q.add(new Node(r, command + 'R'));
                }
            }
        }
        System.out.println(sb);
    }

    static class Node {
        int num;
        String cmd;

        public Node(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
}