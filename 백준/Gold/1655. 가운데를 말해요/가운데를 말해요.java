import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue2 = new PriorityQueue<>();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i<n; i++) {
            int tmp = Integer.parseInt(reader.readLine());

            if (queue1.size() == queue2.size()) {
                queue1.add(tmp);
            } else {
                queue2.add(tmp);
            }

            if (queue1.size() > 0 && queue2.size() > 0 && queue1.peek() > queue2.peek()) {
                int tmp1 = queue1.poll();
                int tmp2 = queue2.poll();
                queue1.add(tmp2);
                queue2.add(tmp1);
            }

            builder.append(queue1.peek()).append("\n");
        }
        System.out.println(builder);
    }
}