import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder("IOI");

        for (int i = 1; i < N; i++) {
            answer.append("OI");
        }


        String s = br.readLine();

        int l = 0;
        int r = N * 2 ;
        int count = 0;
        while (r < M) {
            String str = s.substring(l, r + 1);
            if (str.contentEquals(answer)) {
                count++;
            }
            r++;
            l++;
        }
        System.out.println(count);
    }
}