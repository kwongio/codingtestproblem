import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        //끝나는 시간으로 내림차순
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            q.add(new int[]{a, b});
        }
        int[] first = q.poll();
        int start = first[1] - first[0];
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (start > now[1]) {
                start = now[1] - now[0];
            } else {
                start -= now[0];
            }
        }
        if (start >= 0) {
            System.out.println(start);

        }else{
            System.out.println(-1);
        }
    }
}