import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // M개 뽑아내기
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            int cur = q.indexOf(arr[i]);
            int half;

            if (q.size() % 2 == 0) {
                half = q.size() / 2 - 1;
            } else {
                half = q.size() / 2;
            }
            if (cur <= half) {
                for (int j = 0; j < cur; j++) {
                    q.addLast(q.pollFirst());
                    ans++;
                }
            } else {
                for (int j = 0; j < q.size() - cur; j++) {
                    q.addFirst(q.pollLast());
                    ans++;
                }
            }
            q.pollFirst();
        }
        System.out.println(ans);
    }
}