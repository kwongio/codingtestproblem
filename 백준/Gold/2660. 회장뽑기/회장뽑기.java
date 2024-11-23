import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if(a == -2 && b == -2) break;
            list[a].add(b);
            list[b].add(a);
        }

        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = BFS(i);
        }
        int min = Arrays.stream(score).min().getAsInt();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (min == score[i]) {
                ans.add(i + 1);
            }
        }
        System.out.println(min + " " + ans.size());
        for (Integer an : ans) {
            System.out.print(an + " ");
        }

        // 회장 점수, 후보 수
    }

    private static int BFS(int start) {
        boolean[] visit = new boolean[N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visit[start] = true;
        q.add(new int[]{start, 0});
        int max = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int cnt = now[1];
            max = Math.max(max, cnt);
            for (Integer next : list[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }
        if (max == 0) {
            return 100;
        }
        return max;
    }
}
