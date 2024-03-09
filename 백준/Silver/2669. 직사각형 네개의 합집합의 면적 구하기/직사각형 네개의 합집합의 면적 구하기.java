import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int[][] arr = new int[101][101];


    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        int count = 0;
        visited = new boolean[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (!visited[j][k]) {
                        count++;
                        visited[j][k] = true;
                    }
                }
            }

        }
        System.out.println(count);


    }


}