import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            String str = br.readLine();
            Map<String, String> map = new HashMap<>();
            String dd;
            while (!(dd = br.readLine()).startsWith("what")) {
                String[] split = dd.split(" ");
                map.put(split[0], split[2]);
            }
            String[] split = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String s : split) {
                if(!map.containsValue(s)){
                    sb.append(s).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }

    }
}