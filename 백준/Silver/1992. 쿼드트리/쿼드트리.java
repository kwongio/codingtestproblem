import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int result = 0;
    static int whiteCount = 0;
    static int blueCount = 0;
    static int BLUE = 1;
    static int WHITE = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        quadTree(0, 0, N);
        System.out.println(sb);

    }

    private static void quadTree(int x, int y, int size) {

        if (check(x, y, size)) {
            if (arr[x][y] == 0) {
                sb.append(0);
            }else{
                sb.append(1);
            }

            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quadTree(x, y, newSize);
        quadTree(x, y + newSize, newSize);
        quadTree(x + newSize, y, newSize);
        quadTree(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    private static boolean check(int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
