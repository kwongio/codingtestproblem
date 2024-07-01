import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                arr[s.pop()] = arr[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            arr[s.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
          sb.append(arr[i] + " ");
        }
        sb.append(-1);
        System.out.println(sb);    }
}