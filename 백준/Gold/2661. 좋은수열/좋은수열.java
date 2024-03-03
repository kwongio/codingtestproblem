
import java.io.*;

public class Main {


    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("");
    }

    private static void dfs(String result) {
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0);

        }
        for (int i = 1; i <= 3; i++) {
            if (!isGoodSequence(result + i)) {
                dfs(result + i);
            }
        }

    }

    private static boolean isGoodSequence(String s) {
        int length = s.length() / 2;

        for (int i = 1; i <= length; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return true;
            }
        }

        return false;
    }
}
