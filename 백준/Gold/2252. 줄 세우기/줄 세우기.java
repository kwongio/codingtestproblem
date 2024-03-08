import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] inDegree;
    static List<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            inDegree[b]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print((now + 1) + " ");
            for (Integer next : list[now]) {
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}