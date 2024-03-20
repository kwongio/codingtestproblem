import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (check(str.substring(i))) {
                System.out.println(str.length() + i);
                return;
            }
        }
    }

    static boolean check(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}