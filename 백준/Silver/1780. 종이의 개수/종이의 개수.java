import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int zero = 0;
    static int one = 0;
    static int minusOne = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);

    }

    private static void divide(int x, int y, int size) {

        if (check(x, y, size)) {
            if (arr[x][y] == 0) {
                zero++;
            } else if (arr[x][y] == 1) {
                one++;
            } else if (arr[x][y] == -1) {
                minusOne++;
            }
            return;
        }

        int newSize = size / 3;
        divide(x, y, newSize);
        divide(x + newSize, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y + newSize, newSize);
        divide(x + newSize * 2, y, newSize);
        divide(x, y + newSize * 2, newSize);
        divide(x + newSize * 2, y + newSize, newSize);
        divide(x + newSize, y + newSize * 2, newSize);
        divide(x + newSize * 2, y + newSize * 2, newSize);
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
