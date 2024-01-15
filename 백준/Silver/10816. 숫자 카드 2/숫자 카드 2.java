import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> hashMap = new HashMap<>();


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(key)) {
                bw.write(hashMap.get(key) + " ");
            }else{
                bw.write(0 + " ");
            }
        }
        bw.flush();


    }

}
