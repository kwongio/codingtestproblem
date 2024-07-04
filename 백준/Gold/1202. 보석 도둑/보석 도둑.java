import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static int[][] arr;
    static int[] w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        w = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        Arrays.sort(w);

        int j = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        long answer= 0;
        for (int i = 0; i < K; i++) {
            while (j < N && arr[j][0] <= w[i]) {
                q.offer(arr[j][1]);
                j++;
            }
            if (!q.isEmpty()) {
                answer += q.poll();
            }
        }
        System.out.println(answer);
    }
}