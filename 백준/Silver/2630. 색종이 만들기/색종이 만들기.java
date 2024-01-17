import java.io.*;
import java.util.StringTokenizer;

public class Main {

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
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void partition(int row, int col, int N) {
        if (colorCheck(row, col, N)) {
            if(arr[row][col] == WHITE){
                whiteCount++;
            }else{
                blueCount++;
            }
            return;
        }
        int size = N / 2;
        partition(row, col, size);
        partition(row + size, col, size);
        partition(row, col + size, size);
        partition(row + size, col + size, size);
    }

    private static boolean colorCheck(int row, int col, int n) {
        int color = arr[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
