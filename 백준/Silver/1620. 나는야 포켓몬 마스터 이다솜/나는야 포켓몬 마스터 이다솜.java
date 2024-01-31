import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int M;
    static Map<String, String> map = new HashMap<>();


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int count = 1;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (!map.containsKey(name)) {
                map.put(name, String.valueOf(count));
                map.put(String.valueOf(count), name);
                count++;
            }
        }


        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            System.out.println(map.get(input));
        }

    }
}