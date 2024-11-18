import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            String[] input = s.split("");
            int result = 0;
            int sum = 0;
            for (String str : input) {
                if (str.equals("O")) {
                    sum++;
                    result += sum;
                } else {
                    sum = 0;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}