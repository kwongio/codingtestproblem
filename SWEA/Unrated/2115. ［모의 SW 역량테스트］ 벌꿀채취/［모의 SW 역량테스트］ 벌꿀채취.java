import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int T;
    static int C;
    static int M;

    static int[][] board;
    static boolean[][] visited;
    static boolean[] check;
    static int cost1;
    static int cost2;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N][N];
            check = new boolean[M];
            boolean flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - (M - 1); j++) {

                    for (int k = j; k < j + M; k++) {
                        visited[i][j] = true;
                    }
                    for (int a = 0; a < N; a++) {
                        flag = true;
                        for (int b = 0; b < N - (M - 1); b++) {
                            for (int c = b; c < b + M; c++) {
                                if (visited[a][c]) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (!flag) continue;
                            check(i, j, a, b, 0);
                            answer = Math.max(answer, cost1 + cost2);
                            cost1 = 0;
                            cost2 = 0;
                        }
                    }


                    for (int k = j; k < j + M; k++) visited[i][j] = false;

                }
            }
            System.out.println("#" + (testCase+1) + " " + answer);
        }
    }

    private static void check(int x, int y, int a, int b, int depth) {
        if (depth == M) {
            int count1 = 0;
            int count2 = 0;
            int c1 = 0;
            int c2 = 0;
            for (int k = 0; k < M; k++) {
                if (check[k]) {
                    count1 += board[x][y + k];
                    c1 += (int) Math.pow(board[x][y + k], 2);
                    count2 += board[a][b + k];
                    c2 += (int) Math.pow(board[a][b + k], 2);
                }
            }
            if (count1 <= C) cost1 = Math.max(cost1, c1); // 수익 최대값 계산
            if (count2 <= C) cost2 = Math.max(cost2, c2);
            return;
        }
        check[depth] = true;
        check(x, y, a, b, depth + 1);
        check[depth] = false;
        check(x, y, a, b, depth + 1);
    }
}