import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] map;
    static boolean[] visited;

    static int[] answer;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }

    }

    private static void DFS(int v) {
        for (Integer i : map[v]) {
            if (!visited[i]) {
                visited[i] = true;
                answer[i] = v;
                DFS(i);
            }
        }
    }
}