import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 2];
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        s.push(0);
        int answer = 0;
        for (int i = 1; i < N + 2; i++) {
            while (!s.isEmpty()) {
                int top = s.peek();
                if(arr[top] <= arr[i]) break;
                s.pop();
                answer = Math.max(answer, arr[top] * (i - s.peek() - 1));
            }

            s.push(i);
        }

        System.out.println(answer);


    }
}
