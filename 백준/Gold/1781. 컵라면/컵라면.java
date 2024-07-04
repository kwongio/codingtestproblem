import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;

    static long answer = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < N; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            q.offer(b);
            if (q.size() > a) {
                q.poll();
            }
        }
        while (!q.isEmpty()) {
            answer += q.poll();
        }
        System.out.println(answer);


    }
}
