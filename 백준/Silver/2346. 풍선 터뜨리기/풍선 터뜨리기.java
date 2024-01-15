import java.io.*;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<int[]> queue = new ArrayDeque<>();


        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write("1 ");
        for (int i = 1; i < N; i++) {
            queue.add(new int[]{arr[i], i + 1});
        }
        int moveValue = arr[0];

        while (!queue.isEmpty()) {
            if (moveValue > 0) {
                for (int i = 1; i < moveValue; i++) {
                    queue.add(queue.poll());
                }
                int[] next = queue.poll();
                moveValue = next[0];
                bw.write(next[1] + " ");
            } else {
                for (int i = 1; i < -moveValue; i++) {
                    queue.addFirst(queue.pollLast());
                }
                int[] next = queue.pollLast();
                moveValue = next[0];
                bw.write(next[1] + " ");
            }

        }
        bw.flush();


    }

}
