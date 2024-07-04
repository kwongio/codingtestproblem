import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        list.sort((o1, o2) -> o1[0] - o2[0]);

        int answer = list.get(0)[1] + list.get(0)[0];
        for (int i = 1; i < N; i++) {
            answer = Math.max(answer, list.get(i)[0]);
            answer += list.get(i)[1];
        }
        System.out.println(answer);
    }
}