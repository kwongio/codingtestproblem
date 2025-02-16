import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    static int N;
    static char[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, check(i, j));
                    max = Math.max(max, check(i, j + 1));
                    swap(i, j, i, j + 1);
                }
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, check(i, j));
                    max = Math.max(max, check(i + 1, j));
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);
    }

    public static int check(int x, int y) {
        int max = 1;
        int cnt1 = 1;
        char pre = map[x][0];
        for (int i = 1; i < N; i++) {
            if (map[x][i] == pre) {
                cnt1++;
                max = Math.max(cnt1, max);
            } else {
                pre = map[x][i];
                cnt1 = 1;
            }

        }

        cnt1 = 1;
        pre = map[0][y];
        for (int i = 1; i < N; i++) {
            if (map[i][y] == pre) {
                cnt1++;
                max = Math.max(cnt1, max);
            } else {
                pre = map[i][y];
                cnt1 = 1;
            }

        }
        return max;
    }

    public static void swap(int x, int y, int x1, int y1) {
        char temp = map[x][y];
        map[x][y] = map[x1][y1];
        map[x1][y1] = temp;
    }
}
