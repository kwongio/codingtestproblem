import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        BFS();
    }

    private static void BFS() {
        boolean[] visit = new boolean[N + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        visit[1] = true;
        int maxDistance = 0;
        int destination = 1;
        int same = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int num = now[0];
            int distance = now[1];

            if (maxDistance < distance) {
                maxDistance = distance;
                destination = num;
                same = 1;
            } else if (distance == maxDistance) {
                destination = Math.min(destination, num);
                same++;
            }

            for (int next : list[num]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new int[]{next, distance + 1});
                }
            }
        }
        System.out.println(destination + " "  + maxDistance + " " + same);
    }
}