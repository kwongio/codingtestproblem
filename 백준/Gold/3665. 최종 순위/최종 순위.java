import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] pre;
    static int[] current;
    static int[] indegree;

    static List<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            indegree = new int[N + 1];
            pre = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }

            list = new List[N + 1];
            for (int i = 1; i < N + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    list[pre[i]].add(pre[j]);
                    indegree[pre[j]]++;
                }
            }
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int front = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());
                if (list[front].contains(back)) {
                    list[front].remove((Integer) back);
                    list[back].add(front);
                    indegree[front]++;
                    indegree[back]--;
                } else {
                    list[back].remove((Integer) front);
                    list[front].add(back);
                    indegree[back]++;
                    indegree[front]--;
                }
            }

            StringBuilder sb = new StringBuilder();
            Queue<Integer> q = new ArrayDeque<>();

            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                if (indegree[i] == 0) {
                    cnt++;
                    q.add(i);
                }
            }

            if (cnt > 1) {
                System.out.println("?");
                continue;
            }

            boolean isFinished = false;
            for (int i = 1; i <= N; i++) {
                if (q.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    isFinished = true;
                    break;
                }
                int now = q.poll();
                sb.append(now).append(" ");
                for (int next : list[now]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
            if (isFinished == true) continue;
            System.out.println(sb.toString());
        }
    }
}