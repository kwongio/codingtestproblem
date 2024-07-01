import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int H;
    static int W;
    static char[][] board;
    static int[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new char[H][W];
        time = new int[H][W];
        for (int i = 0; i < H; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                board[i][j] = charArray[j];
                if (board[i][j] != 'c') {
                    time[i][j] = -1;
                }

            }
        }

        for (int i = 0; i < H; i++) {
            int count = 0;
            boolean groom = false;
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 'c') {
                    count = 0;
                    groom = true;
                    continue;
                }
                if (time[i][j] == 0) {
                    groom = false;
                }
                if (groom) {
                    count++;
                    time[i][j] = count;
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(time[i][j] + " ");
            }
            System.out.println();
        }
    }
}
