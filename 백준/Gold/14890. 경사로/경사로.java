import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            if (checkRow(i)) {
                answer++;
            }
            if (checkCol(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean checkRow(int s) {
        boolean[] check = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[s][i] - map[s][i + 1];
            if (diff > 1 || diff < -1) return false;
            if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0) return false;
                    if (map[s][i - j] != map[s][i + 1] - 1) return false;
                    if (check[i - j]) return false;
                    check[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 0; j < L; j++) {
                    if(i + 1 + j >= N) return false;
                    if (map[s][i + 1 + j] != map[s][i] - 1) return false;
                    if (check[i + 1 + j]) return false;
                    check[i + 1 + j] = true;
                }

            }
        }
        return true;
    }

    private static boolean checkCol(int s) {
        boolean[] check = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][s] - map[i+1][s];
            if (diff > 1 || diff < -1) return false;
            if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0) return false;
                    if (map[i -j][s] != map[i+1][s] - 1) return false;
                    if (check[i - j]) return false;
                    check[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 0; j < L; j++) {
                    if(i + 1 + j >= N) return false;
                    if (map[i + 1 + j][s] != map[i][s] - 1) return false;
                    if (check[i + 1 + j]) return false;
                    check[i + 1 + j] = true;
                }

            }
        }
        return true;
    }
}
