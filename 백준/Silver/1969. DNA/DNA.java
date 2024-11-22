import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) { // 각 자리마다 많이 나온것
            int[] a = new int[26];
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                a[str.charAt(j) - 'A']++;
            }
            int maxIdx = 0;
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (max < a[i]) {
                    maxIdx = i;
                    max = a[i];
                }
            }
            char c = (char) (maxIdx + 'A');
            sb.append(c);
            sum += N - max;
        }

        System.out.println(sb);
        System.out.println(sum);
    }

}
