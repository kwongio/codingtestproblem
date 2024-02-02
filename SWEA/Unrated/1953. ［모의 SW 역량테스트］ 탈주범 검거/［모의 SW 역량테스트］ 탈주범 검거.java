import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {


    //상 우 하 좌
    static int[] dx = {-1, 0, 1, 0,};
    static int[] dy = {0, 1, 0, -1};
    static int[][] structure = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1},
            {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}};
    static int answer;
    static int[][] arr;
    static int N;
    static int M;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //세로
            M = Integer.parseInt(st.nextToken());//가로
            int R = Integer.parseInt(st.nextToken());//멘톨 세로
            int C = Integer.parseInt(st.nextToken());//멘홀 가로
            int L = Integer.parseInt(st.nextToken());// 소요시간

            arr = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BFS(R, C, L);

            System.out.println("#" + testcase + " " + answer);
        }
    }

    private static void BFS(int r, int c, int L) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, 1});
        visited[r][c] = true;
        answer++;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[2] == L) {
                return;
            }
            int[] dirs = structure[arr[now[0]][now[1]]];
            for (int i = 0; i < dirs.length; i++) {
                if (dirs[i] == 0) continue;
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (arr[nx][ny] <= 0) continue;
                if (visited[nx][ny]) continue;
                if (structure[arr[nx][ny]][(i + 2) % 4] == 1) {
                    visited[nx][ny] = true;
                    answer++;
                    q.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
    }
}
