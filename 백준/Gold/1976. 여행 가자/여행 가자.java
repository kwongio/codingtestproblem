import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시의 수
        M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    list[i + 1].add(j + 1);
                    list[j + 1].add(i + 1);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[N + 1];
        BFS(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < M - 1; i++) {
            if (!visit[Integer.parseInt(st.nextToken())]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    private static void BFS(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visit[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (Integer next : list[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
    }
}