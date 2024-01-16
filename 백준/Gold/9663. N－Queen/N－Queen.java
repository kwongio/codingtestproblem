import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N;
    static int[] map;
    static int count = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N];

        nQueen(0);
        System.out.println(count);

    }

    private static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            map[depth] = i;

            if (possible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean possible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (map[depth] == map[i]) return false;
            else if (Math.abs(depth - i) == Math.abs(map[depth] - map[i])) return false;

        }
        return true;


    }


}