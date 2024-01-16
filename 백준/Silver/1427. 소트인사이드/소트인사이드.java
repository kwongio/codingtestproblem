import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split("");
        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list, Collections.reverseOrder());

        for (Integer i : list) {
            System.out.print(i);
        }

    }

}
