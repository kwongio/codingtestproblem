import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static int T;
    static int a, b;
    static char[] cmd = {'D', 'S', 'L', 'R'};

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
                if(num == b){
                    System.out.println(command);
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int d = (num * 2) % 10000;
                    int s = num == 0 ? 9999 : num - 1;
                    int l = (num % 1000 * 10) + num / 1000;
                    int r = (num % 10 * 1000) + num / 10;
                    if (!visit[d] && cmd[j] == 'D') {
                        visit[d] = true;
                        q.add(new Node(d, command + cmd[j]));
                    } else if (!visit[s] && cmd[j] == 'S') {
                        visit[s] = true;
                        q.add(new Node(s, command + cmd[j]));
                    } else if (!visit[l] && cmd[j] == 'L') {
                        visit[l] = true;
                        q.add(new Node(l, command + cmd[j]));
                    } else if (!visit[r] && cmd[j] == 'R') {
                        visit[r] = true;
                        q.add(new Node(r, command + cmd[j]));
                    }
                }
            }
        }
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