import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visit = new int[100001];
    static int[] pre = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        BFS(N);
    }

    private static void BFS(int s) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(s);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                System.out.println(visit[now]);
                Stack<Integer> stack = new Stack<>();
                int i = K;
                while (i != N) {
                    int item = pre[i];
                    stack.push(item);
                    i = item;
                }
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop()+ " ");
                }
                System.out.println(K);
                System.exit(0);
            }
            for (int n : new int[]{now + 1, now * 2, now - 1}) {
                if (0 <= n && n <= 100000) {
                    if (visit[n] == 0) {
                        visit[n] = visit[now] + 1;
                        q.offer(n);
                        pre[n] = now;
                    }
                }
            }
        }
    }
}