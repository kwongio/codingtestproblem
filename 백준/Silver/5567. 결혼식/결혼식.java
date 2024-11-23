import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            list[b].add(a);
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        visit[0] = true;
        int count = 0;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (Integer i : list[now[0]]) {
                if (!visit[i] && now[1] + 1 <= 2) {
                    visit[i] = true;
                    q.add(new int[]{i, now[1] + 1});
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}