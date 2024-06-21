import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static char[][][] resultBoard;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        resultBoard = new char[3][R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                resultBoard[0][i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < 2; i++) {
            boom(i);
        }


        if (N % 2 == 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
        } else {
            if (N == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(resultBoard[0][i][j]);
                    }
                    System.out.println();
                }
            } else if (N % 4 == 3) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(resultBoard[1][i][j]);
                    }
                    System.out.println();
                }
            } else if (N % 4 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(resultBoard[2][i][j]);
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void boom(int i) {
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if (resultBoard[i][j][k] == 'O') {
                    resultBoard[i + 1][j][k] = '.';
                    for (int l = 0; l < 4; l++) {
                        int nx = dx[l] + j;
                        int ny = dy[l] + k;
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            resultBoard[i + 1][nx][ny] = '.';
                        }
                    }
                }
            }
        }
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if (resultBoard[i + 1][j][k] != '.') {
                    resultBoard[i + 1][j][k] = 'O';
                }
            }
        }
    }
}