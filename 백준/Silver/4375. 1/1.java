import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            long count = 1;
            long num = 1;
            while (true) {
                if (num % N == 0) {
                    System.out.println(count);
                    break;
                }
                num = num * 10 + 1;
                num %= N;
                count++;
            }
        }
    }
}