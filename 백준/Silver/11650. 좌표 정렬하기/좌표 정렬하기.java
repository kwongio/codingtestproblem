import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }
        list.sort( (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]) {
                    return 1;
                }
            } else {
                if( o1[0] > o2[0]){
                    return 1;
                }
            }
            return -1;
        });
        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }

    }

}
