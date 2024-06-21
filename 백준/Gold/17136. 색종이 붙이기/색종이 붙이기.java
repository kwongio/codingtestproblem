import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MAX_VALUE;
    static int N = 10;
    static int[][] paper = new int[10][10];
    static boolean[][] visit = new boolean[10][10];
    static int[] colorPaper = new int[]{1, 2, 3, 4, 5};
    static int[] colorPaperCount = new int[]{5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, 0);
        if (max == Integer.MAX_VALUE) {
            max = -1;
        }
        System.out.println(max);
    }

    private static void DFS(int x, int y, int count) {
        if (x >= 9 && y >= 10) {
            max = Math.min(max, count);
            return;
        }

        if (y >= N) {
            DFS(x + 1, 0, count);
            return;
        }

        if (paper[x][y] == 1 && !visit[x][y]) {
            for (int i = 4; i >= 0; i--) {
                if (!visit[x][y] && check(x, y, colorPaper[i]) && colorPaperCount[i] > 0) {
                    attach(x, y, colorPaper[i]);
                    DFS(x, y + colorPaper[i], count + 1);
                    dettach(x, y, colorPaper[i]);
                }
            }
        } else {
            DFS(x, y + 1, count);
        }
    }

    private static void attach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                visit[i][j] = true;
            }
        }
        colorPaperCount[size - 1]--;
    }

    private static void dettach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                visit[i][j] = false;
            }
        }
        colorPaperCount[size - 1]++;
    }


    private static boolean check(int x, int y, int size) {
        if (x + size > N || y + size > N) return false;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != 1 || visit[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}