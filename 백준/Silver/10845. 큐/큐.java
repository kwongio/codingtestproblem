import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = st.nextToken();

            if (input.equals("push")) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            if (input.equals("pop")) {
                if (queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.poll());
                }
            }
            if (input.equals("size")) {
                System.out.println(queue.size());
            }
            if (input.equals("empty")) {
                if (queue.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }

            }
            if (input.equals("front")) {
                if (queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.getFirst());
                }

            }
            if (input.equals("back")) {
                if (queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.getLast());
                }

            }
        }

    }


}
