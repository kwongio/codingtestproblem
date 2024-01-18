import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list;
    static int[] seq;
    static int count = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new ArrayList<>();
        seq = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        visited[R] = true;
        seq[R] = count++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    seq[next] = count++;
                    queue.add(next);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            stringBuilder.append(seq[i] + "\n");
        }
        System.out.println(stringBuilder);
    }


}
