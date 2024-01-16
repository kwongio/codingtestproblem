import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            int len = (int) Math.pow(3, N);

            sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }
            recur(0, sb.length());
            System.out.println(sb);
        }
    }

    private static void recur(int start, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size / 3;

        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            sb.setCharAt(i, ' ');
        }
        recur(start, newSize);
        recur(start + newSize * 2, newSize);
    }


}