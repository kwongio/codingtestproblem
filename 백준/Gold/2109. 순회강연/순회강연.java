import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static int[][] arr;

    static PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < N; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            q.offer(a);
            while (q.size() > b) {
                q.poll();
            }
        }
        int answer = 0;
        while (!q.isEmpty()) {
            answer += q.poll();
        }
        System.out.println(answer);
    }
}
