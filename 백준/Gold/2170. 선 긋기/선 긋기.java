import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<int[]> list = new ArrayList<>();

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

        int first = list.get(0)[0];
        int second = list.get(0)[1];
        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (second < list.get(i)[0]) {
                answer += (second - first);
                first = list.get(i)[0];
                second = list.get(i)[1];
            }else if(list.get(i)[0] <= second && list.get(i)[1] >= second)
                second = list.get(i)[1];
        }
        answer += second - first;
        System.out.println(answer);

    }
}