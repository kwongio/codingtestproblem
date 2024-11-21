import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static Map<Integer, List<int[]>> map;
    static int[] cnt;
    static char[][] board;
    static int N;
    static int M;
    static int P;
    static int[] s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cnt = new int[P + 1];

        s = new int[P];
        for (int i = 0; i < P; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        board = new char[N][M];
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = c[j];
                if (board[i][j] != '.' && board[i][j] != '#') {
                    List<int[]> list = map.computeIfAbsent(board[i][j] - '0', (s) -> new ArrayList<>());
                    list.add(new int[]{i, j});
                    map.put(board[i][j] - '0', list);
                }
            }
        }
        BFS();
        for (int i = 1; i <= P; i++) {
            System.out.print(cnt[i] + " ");
        }
    }

    private static void BFS() {
        Map<Integer, ArrayDeque<int[]>> q = new HashMap<>();

        for (int i = 1; i <= P; i++) {
            q.computeIfAbsent(i, k -> new ArrayDeque<>());
        }

        int moveCount = 0;
        boolean[][] visit = new boolean[N][M];
        for (Integer i : map.keySet()) {
            ArrayDeque<int[]> move = q.get(i);
            List<int[]> list = map.get(i);
            for (int[] cur : list) {
                move.add(new int[]{cur[0], cur[1]});
                moveCount++;
                cnt[i]++;
                visit[cur[0]][cur[1]] = true;
            }

        }
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        while (moveCount > 0) {
            for (int i = 1; i <= P; i++) { // 한 턴씩 돌아가면서 해야함
                ArrayDeque<int[]> pq = q.get(i);
                for (int l = 0; l < s[i - 1]; l++) {
                    int size = pq.size();
                    for (int j = 0; j < size; j++) {
                        int[] now = pq.poll();
                        moveCount--;
                        int x = now[0];
                        int y = now[1];
                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + x;
                            int ny = dy[d] + y;
                            if (!(nx >= 0 && nx < N && ny >= 0 && ny < M) || visit[nx][ny] || board[nx][ny] == '#') {
                                continue;
                            }
                            visit[nx][ny] = true;
                            board[nx][ny] = (char) (i + '0');
                            cnt[i]++;
                            pq.add(new int[]{nx, ny});
                            moveCount++;
                        }
                    }
                    if (pq.isEmpty()) {
                        break;
                    }
                }

            }
        }
    }
}