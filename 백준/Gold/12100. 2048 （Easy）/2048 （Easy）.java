import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int max;
    static int[] d = {1, 2, 3, 4};//상 하 좌 우

    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, board);
        System.out.println(max);
    }

    private static void DFS(int depth, int[][] b) {
        if (depth == 5) {
            int v = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    v = Math.max(v, b[i][j]);
                }
            }
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(b[i]));
//            }
//            System.out.println();
            max = Math.max(v, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] temp = new int[N][N];
            int[][] send = new int[N][N];
            for (int j = 0; j < N; j++) temp[j] = Arrays.copyOf(b[j], N);
            move(d[i], b);
            for (int j = 0; j < N; j++) {
                send[j] = Arrays.copyOf(b[j], N);
            }
            DFS(depth + 1, send);
            for (int j = 0; j < N; j++) b[j] = Arrays.copyOf(temp[j], N);
        }
    }

    private static void move(int dir, int[][] b) {
        visit = new boolean[N][N];
        if (dir == 1) { //좌
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (b[i][j] != 0) {
                        for (int k = j; k > 0; k--) {
                            if (b[i][k - 1] != 0) {
                                if (b[i][k - 1] == b[i][k] && !visit[i][k - 1]) {
                                    visit[i][k - 1] = true;
                                    b[i][k - 1] += b[i][k];
                                    b[i][k] = 0;
                                }
                                break;
                            } else {
                                b[i][k - 1] = b[i][k];
                                b[i][k] = 0;
                            }
                        }
                    }
                }
            }
        } else if (dir == 2) {//우
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (b[i][j] != 0) {
                        for (int k = j; k < N - 1; k++) {
                            if (b[i][k + 1] != 0) {
                                if (b[i][k + 1] == b[i][k] && !visit[i][k + 1]) {
                                    visit[i][k + 1] = true;
                                    b[i][k + 1] += b[i][k];
                                    b[i][k] = 0;
                                }
                                break;
                            } else {
                                b[i][k + 1] = b[i][k];
                                b[i][k] = 0;
                            }
                        }
                    }
                }
            }

        } else if (dir == 3) {//상
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (b[i][j] != 0) {
                        for (int k = i; k > 0; k--) {
                            if (b[k - 1][j] != 0) {
                                if (b[k - 1][j] == b[k][j] && !visit[k - 1][j]) {
                                    visit[k - 1][j] = true;
                                    b[k - 1][j] += b[k][j];
                                    b[k][j] = 0;
                                }
                                break;
                            } else {
                                b[k - 1][j] = b[k][j];
                                b[k][j] = 0;
                            }
                        }
                    }
                }
            }
        } else if (dir == 4) {//하
            for (int j = 0; j < N; j++) {
                for (int i = N - 1; i >= 0; i--) {
                    if (b[i][j] != 0) {
                        for (int k = i; k < N - 1; k++) {
                            if (b[k + 1][j] != 0) {
                                if (b[k + 1][j] == b[k][j] && !visit[k + 1][j]) {
                                    visit[k + 1][j] = true;
                                    b[k + 1][j] += b[k][j];
                                    b[k][j] = 0;
                                }
                                break;
                            } else {
                                b[k + 1][j] = b[k][j];
                                b[k][j] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
}