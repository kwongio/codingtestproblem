import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        int start = 1;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        String[] s = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            int num = Integer.parseInt(s[j]);

            while (!q.isEmpty() && q.peekFirst() == start) {
                start++;
                q.pollFirst();
            }
            if (num != start) {
                q.addFirst(num);
            }else{
                start++;
            }
        }
        while(!q.isEmpty() && q.peekFirst() == start){
            start++;
            q.pollFirst();
        }
        if (q.isEmpty() ) {
            System.out.println("Nice");
        } else {

            System.out.println("Sad");
        }
    }
}