import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long[] arr;
    static List<Integer>[] list;
    static int[] child;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        child = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        arr = new long[N + 1];
        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            if (t.equals("W")) {
                amount *= -1;
            }
            arr[i] = amount;
            list[i].add(next);
            child[next]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 2; i <= N; i++) {
            if (child[i] == 0) {
                q.add(i); // 자식노드
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer i : list[now]) {
                if (arr[now] > 0) {
                    arr[i] += arr[now];
                }
                if(--child[i] == 0) q.add(i);
            }

        }
        System.out.println(arr[1]);
    }
}