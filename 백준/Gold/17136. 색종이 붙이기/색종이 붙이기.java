import org.w3c.dom.xpath.XPathResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N = 10;
    static int[][] map = new int[N][N];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);


    }

    private static void DFS(int x, int y, int count) {
        if (x >= 9 && y > 9) {
            answer = Math.min(answer, count);
            return;
        }
        if (answer <= count) {
            return;
        }

        if (y > 9) {
            DFS(x + 1, 0, count);
            return;
        }

        if (map[x][y] == 1) {
            for (int p = 5; p >=1; p--) {
                if (paper[p] > 0 && check(x, y, p)) {
                    paper[p]--;
                    attach(x, y, p, 0);
                    DFS(x, y + 1, count + 1);
                    paper[p]++;
                    attach(x, y, p, 1);
                }
            }
        } else {
            DFS(x, y + 1, count);
        }

    }

    private static void attach(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = value;
            }
        }
    }


    private static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N) {
                    return false;
                }
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}