import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int length;
    static int N;
    static int K;
    static int L;

    //북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int d = 1;
    static int x = 0;
    static int y = 0;
    static int answer = 0;
    static HashMap<Integer, String> hash = new HashMap<>();
    static List<int[]> snake = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        snake.add(new int[]{0, 0});
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            hash.put(X, C);

        }
        while (true) {
            answer++;
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                for (int[] s : snake) {
                    if (s[0] == nx && s[1] == ny) {
                        System.out.println(answer);
                        return;
                    }
                }

                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    snake.add(new int[]{nx, ny});
                } else {
                    snake.add(new int[]{nx, ny});
                    snake.remove(0);

                }
                x = nx;
                y = ny;
                if (hash.containsKey(answer)) {
                    String s = hash.get(answer);
                    if (s.equals("L")) {
                        d = (d - 1 + 4) % 4;
                    } else {
                        d = (d + 1 + 4) % 4;
                    }

                }
            } else {
                System.out.println(answer);
                return;
            }
        }
    }
}
