import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] list;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                list[0].add(i);
            } else {
                list[parent].add(i);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            answer[num] += score;

        }

        for (int i = 1; i < N + 1; i++) {
            for (Integer next : list[i]) {
                answer[next] += answer[i];
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

}