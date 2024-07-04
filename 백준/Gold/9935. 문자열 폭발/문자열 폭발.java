import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        String boom = br.readLine();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            answer.append(str.charAt(i));
            if (answer.length() >= boom.length() && answer.substring(answer.length() - boom.length()).equals(boom)) {
                answer.delete(answer.length() - boom.length(), answer.length());
            }
        }
        if (answer.toString().isBlank()) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer);

        }
    }
}