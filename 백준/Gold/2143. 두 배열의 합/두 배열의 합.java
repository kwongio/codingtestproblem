import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        List<Integer> list1 = new ArrayList<>();
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                list1.add(sum);
            }
        }

        M = Integer.parseInt(br.readLine());
        List<Integer> list2 = new ArrayList<>();
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                list2.add(sum);
            }
        }

        Collections.sort(list1);
        list2.sort(Collections.reverseOrder());

        int s = 0;
        int e = 0;
        long cnt = 0;

        while (s < list1.size() && e < list2.size()) {
            int a = list1.get(s);
            int b = list2.get(e);
            long sum = a + b;
            if (sum == T) {
                long cnt1 = 0;
                long cnt2 = 0;

                while (s < list1.size() && list1.get(s) == a) {
                    s++;
                    cnt1++;
                }
                while (e < list2.size() && list2.get(e) == b) {
                    e++;
                    cnt2++;
                }
                cnt += cnt1 * cnt2;
            } else if (sum > T) {
                e++;
            } else if (sum < T) {
                s++;
            }
        }
        System.out.println(cnt);
    }
}
