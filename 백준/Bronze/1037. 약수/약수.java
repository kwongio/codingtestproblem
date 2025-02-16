import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int v = Integer.parseInt(st.nextToken());
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
        System.out.println(max * min);

    }
}
