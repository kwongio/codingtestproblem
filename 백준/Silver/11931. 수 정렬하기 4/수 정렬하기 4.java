import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>(Comparator.comparing(o -> -o));
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : set) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}