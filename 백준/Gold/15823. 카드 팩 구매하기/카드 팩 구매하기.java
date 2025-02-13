import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int s = 1;
        int e = N;
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (check(mid)) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(s - 1);
    }

    private static boolean check(int mid) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int s = 0;
        int e = 0;
//        System.out.println("===========");
//        System.out.println(mid);
        while (e < N) {
//            System.out.println(set);
            if (set.contains(card[e])) {
                set.remove(card[s]);
                s++;
            } else {
                set.add(card[e]);
                if (set.size() == mid) {
                    set.clear();
                    e++;
                    s = e;
                    count++;
                } else {
                    e++;
                }
            }
        }

        return count >= M;
    }
}
