import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] flower = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
    static int[][] board;
    static boolean[][] visit;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, 0, 0);
        System.out.println(min);
    }

    private static void DFS(int sx, int sy, int depth, int cost) {
        if (depth == 3) {
            min = Math.min(min, cost);
            return;
        }
        for (int i = sx; i < N - 2; i++) {
            for (int j = sy; j < N - 2; j++) {
                if (check(i, j)) {
                    fillFlower(i, j, true);
                    DFS(sx, sy, depth + 1, cost + getCost(i, j));
                    fillFlower(i, j, false);
                }

            }
        }
    }

    private static void fillFlower(int x, int y, boolean b) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (flower[i - x][j - y] == 1) {
                    visit[i][j] = b;
                }
            }
        }
    }

    private static int getCost(int x, int y) {
        int cost = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (flower[i - x][j - y] == 1) {
                    cost += board[i][j];
                }
            }
        }
        return cost;
    }

    private static boolean check(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (flower[i - x][j - y] == 1 && visit[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}