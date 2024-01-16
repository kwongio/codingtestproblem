import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            list.add(new String[]{age, name});
        }


        list.sort((o1, o2) -> {
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);

        });
        for (String[] s : list) {
            System.out.println(s[0] + " " + s[1]);
        }
    }
}
