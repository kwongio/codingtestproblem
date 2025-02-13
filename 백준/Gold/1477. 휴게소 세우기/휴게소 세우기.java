import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, L;
    static List<Integer> list = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list.add(0);
        list.add(L);
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int s = 1;
        int e = L - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int sum = 0;
            for (int i = 1; i < list.size(); i++) {
                sum += (list.get(i) - list.get(i - 1) - 1) / mid;
            }
            if (sum > M) {
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        System.out.println(s);
    }
}
