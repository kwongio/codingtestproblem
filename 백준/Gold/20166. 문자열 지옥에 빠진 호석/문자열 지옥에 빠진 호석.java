import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static Map<String, Integer> hashMap = new HashMap<>();
    static int K;
    static int N;
    static int M;
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    static int maxLen = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = charArray[j];
            }
        }
        String[] answer = new String[K];
        for (int i = 0; i < K; i++) {
            String key = br.readLine();
            hashMap.put(key, 0);
            answer[i] = key;
            maxLen = Math.max(key.length(), maxLen);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                BFS(i, j);

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(hashMap.get(answer[i]) + "\n");
        }
        System.out.println(sb);


    }

    private static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1, map[x][y] + ""));
        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.length > maxLen) {
                continue;
            }
            if (hashMap.containsKey(point.str)) {
                hashMap.put(point.str, hashMap.get(point.str) + 1);
            }
            for (int i = 0; i < 8; i++) {
                int nx = (point.x + dx[i] + N) % N;
                int ny = (point.y + dy[i] + M) % M;
                q.add(new Point(nx, ny, point.length + 1, point.str + map[nx][ny]));
            }
        }

    }

    static class Point {
        public int x;
        public int y;
        public int length;
        public String str;

        public Point(int x, int y, int length, String str) {
            this.x = x;
            this.y = y;
            this.length = length;
            this.str = str;
        }
    }
}
