import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Map<String, Integer> map = new HashMap<>();
            int M = Integer.parseInt(br.readLine());
            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String nae = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int result = 1;
            for (Integer value : map.values()) {

                result *= value + 1;
            }
            System.out.println(result - 1);
        }
    }
}