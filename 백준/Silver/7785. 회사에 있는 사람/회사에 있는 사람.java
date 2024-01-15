import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new LinkedHashSet<>();


        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String input = st.nextToken();
            if (input.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);

            }
        }

        List<String> list = new ArrayList<>();
        for (String s : set) {
            list.add(s);
        }

        Collections.sort(list, Collections.reverseOrder());
        list.stream().forEach(System.out::println);
    }

}
