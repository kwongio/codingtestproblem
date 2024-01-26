import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N;
    static int M;
    static int R;
    static int[] dx = {0, 1, 0, -1}; // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < Math.min(N, M) / 2; j++) {
                int temp = map[j][j];
                for (int k = j; k < M - j - 1; k++) {
                    map[j][k] = map[j][k + 1];
                }
                for (int k = j; k < N - j - 1; k++) {
                    map[k][M - j - 1] = map[k + 1][M - j - 1];
                }
                for (int k = M - j - 1; k > j; k--) {
                    map[N - 1 - j][k] = map[N - 1 - j][k - 1];
                }
                for (int k = N - j - 1; k > j; k--) {
                    map[k][j] = map[k - 1][j];
                }
                map[j + 1][j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

}