import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            result = 0;
            int palindrome = palindrome(str, 0, str.length() - 1);
            System.out.println(palindrome + " " + result);

        }

    }

    private static int palindrome(String str, int left, int right) {
        result++;
        if (left >= right) {
            return 1;
        } else if (str.charAt(left) != str.charAt(right)) {
            return 0;
        } else {
            return palindrome(str, left + 1, right - 1);
        }

    }
}