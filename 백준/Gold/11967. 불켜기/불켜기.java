import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static boolean[][] visit;
    static boolean[][] light;
    static Map<String, List<String>> map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();
            String a = st.nextToken();
            String b = st.nextToken();
            String key = x + "," + y;
            String value = a + "," + b;
            map.computeIfAbsent(key, k -> new ArrayList<>());
            List<String> list = map.get(key);
            list.add(value);
        }

        visit = new boolean[N + 1][N + 1];
        light = new boolean[N + 1][N + 1];
        BFS(1, 1);
    }

    private static void BFS(int sx, int sy) {
        int count = 1;
        visit[sx][sy] = true;
        light[sx][sy] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();
            int x = now[0];
            int y = now[1];
            List<String> list = map.get(x + "," + y);
            if (list != null) {
                for (String s : list) {
                    String[] cur = s.split(",");
                    int xx = Integer.parseInt(cur[0]);
                    int yy = Integer.parseInt(cur[1]);
//                    System.out.println(xx + " " + yy);
                    if (!light[xx][yy]) { // 불켜진 곳
                        light[xx][yy] = true;
                        count++;
                        for (int i = 0; i < 4; i++) {
                            int nx = xx + dx[i];
                            int ny = yy + dy[i];
                            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && visit[nx][ny]) { // 직접 방문한 곳과 연결되어있으면 이동이 가능
                                visit[xx][yy] = true;
                                q.add(new int[]{xx, yy});
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && light[nx][ny] && !visit[nx][ny]) { // 직접 방문한 곳과 연결되어있으면 이동이 가능
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(count);
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(visit[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(swt[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}