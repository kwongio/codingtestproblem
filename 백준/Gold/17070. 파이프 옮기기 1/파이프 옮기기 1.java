import org.w3c.dom.xpath.XPathResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 1, 1);
        System.out.println(answer);

    }

    private static void DFS(int x, int y, int direction) {
        if (x == N - 1 && y == N - 1) {
            answer++;
            return;
        }

        if (direction == 1) {
            if (y + 1 < N && map[x][y + 1] == 0) {
                DFS(x, y + 1, 1);
            }

        } else if (direction == 2) {
            if (x + 1 < N && map[x + 1][y] == 0) {

                DFS(x + 1, y, 2);
            }

        } else if (direction == 3) {
            if (y + 1 < N && map[x][y + 1] == 0) {

                DFS(x, y + 1, 1);
            }

            if (x + 1 < N && map[x + 1][y] == 0) {
                DFS(x + 1, y, 2);
            }
        }
        if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 3);
        }
    }

}