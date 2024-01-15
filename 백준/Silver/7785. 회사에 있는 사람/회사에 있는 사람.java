import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String,String> set = new HashMap<>();


        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String input = st.nextToken();
            if (input.equals("enter")) {
                set.put(name, "0");
            } else {
                set.remove(name);

            }
        }
        ArrayList<String> list = new ArrayList<>();

        for (String key : set.keySet()) {
            list.add(key);
        }
        Collections.sort(list, Collections.reverseOrder());
        list.stream().forEach(System.out::println);


    }

}
