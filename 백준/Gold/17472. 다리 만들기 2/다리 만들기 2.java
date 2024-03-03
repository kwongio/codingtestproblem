import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int landNum = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] parent;
    static boolean[][] visited;
    static List<int[]> bridge = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        parent = new int[7];
        for (int i = 1; i <= 6; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    visited = new boolean[N][M];
                    makeBridge(i, j);
                }
            }
        }
        int answer = 0;
        int count = 0;
        bridge.sort((o1, o2) -> o1[2] - o2[2]);
        for (int[] b : bridge) {
            if (find(b[0]) != find(b[1])) {
                union(b[0], b[1]);
                count++;
                answer += b[2];
            }
        }
        if(count != landNum - 1){
            System.out.println(-1);
            return;
        }

//        System.out.println(landNum);
//        for (int i = 1; i < 7; i++) {
//            System.out.println(parent[i]);
//        }



        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void makeBridge(int x, int y) {
        int currentColor = map[x][y];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && (map[nx][ny] != currentColor || map[nx][ny] == 0) && (nx == x || ny == y)) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, now[2] + 1});
                    } else if (map[nx][ny] != currentColor) {
                        if (now[2] >= 2) {
                            bridge.add(new int[]{currentColor, map[nx][ny], now[2]});
//                            for (int j = 0; j < N; j++) {
//                                for (int k = 0; k < N; k++) {
//                                    System.out.print(visited[j][k] + "    ");
//                                }
//                                System.out.println();
//                            }
//                            System.out.println();
                            return;
                        }
                    }
                }
            }
        }
    }

    private static void BFS(int x, int y) {
        landNum++;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = landNum;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    map[nx][ny] = landNum;
                }
            }
        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}