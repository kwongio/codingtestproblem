import javax.sound.sampled.EnumControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int N;
    static int M;
    static int K;
    static int X;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
        }

        BFS(X);
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

    private static void BFS(int v) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{v, 0});
        visited[v] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[1] == K){
                queue.add(now[0]);
                continue;
            }
            for (Integer i : list[now[0]]) {
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i, now[1] + 1});
                }
            }

        }


    }

}
