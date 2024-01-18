import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<int[]> s = new Stack<>();

        long ans = 0;
        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && s.peek()[0] < arr[i]) {
                ans += s.pop()[1];
            }

            if (s.isEmpty()) {
                s.push(new int[]{arr[i], 1});
            } else {
                if (s.peek()[0] > arr[i]) {
                    s.push(new int[]{arr[i], 1});
                    ans++;
                } else {
                    ans += s.peek()[1]++;
                    if (s.size() > 1) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
