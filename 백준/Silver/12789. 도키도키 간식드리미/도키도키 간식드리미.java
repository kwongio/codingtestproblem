import java.io.*;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {

            if (count == q.peek()) {
                q.poll();
                count++;
            } else {
                if (!s.isEmpty() && s.peek() == count) {
                    count++;
                    s.pop();
                } else {
                    s.push(q.poll());
                }
            }
        }
        while (!s.isEmpty()) {
            if (s.peek() == count) {
                s.pop();
                count++;
            }else{
                System.out.println("Sad");
                return;
            }

        }


        bw.write("Nice");

        bw.flush();


    }

}
