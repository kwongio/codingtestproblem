import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Comparator<String> comparing = Comparator.comparing(String::length);
        comparing = comparing.thenComparing((o1, o2) -> {
            char[] c1 = o1.toCharArray();
            int cSum = 0;
            for (char c : c1) {
                if (Character.isDigit(c)) {
                    cSum += c - '0';
                }
            }
            char[] c2 = o2.toCharArray();
            int c2Sum = 0;
            for (char c : c2) {
                if (Character.isDigit(c)) {
                    c2Sum += c - '0';
                }
            }
            if(cSum > c2Sum){
                return 1;
            }else if(cSum < c2Sum){
                return -1;
            }
            return 0;
        });
        comparing = comparing.thenComparing(String::compareTo);

        list.sort(comparing);

        for (String s : list) {
            System.out.println(s);
        }

    }
}