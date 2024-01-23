import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] select;
    static int M;
    static int N;
    static int[][] map;
    static int D;
    static int answer = 0;
    static int[][] copyMap;
    static int enemyCount = 0;
    static int copyEnemyCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수
        D = Integer.parseInt(st.nextToken()); //공격 제한 거리
        select = new int[3];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    enemyCount++;
                }
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int idx, int start) {
        if (idx == 3) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                copyMap[i] = map[i].clone();
            }
            copyEnemyCount = enemyCount;
            int score = 0;
            while (copyEnemyCount > 0) {
                for (int i = 0; i < 3; i++) {
                    game(select[i]);
                }
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(copyMap[i][j] + " ");
//                    }
//                    System.out.println();
//                }
                score += getScore();
                enemyAttack();
            }

            answer = Math.max(answer, score);
            return;
        }

        for (int i = start; i < M; i++) {
            select[idx] = i;
            DFS(idx + 1, i + 1);
        }
    }


    private static void enemyAttack() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 1) {
                    int next = i + 1;
                    copyMap[i][j] = 0;
                    if (next == N) {
                        copyEnemyCount--;
                    } else {
                        copyMap[next][j] = 1;
                    }
                }
            }
        }
    }

    private static int getScore() {
        int score = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == -1) {
                    copyMap[i][j] = 0;
                    score++;
                    copyEnemyCount--;
                }
            }
        }
        return score;
    }

    private static void game(int k) {
        int[] e = new int[2];
        int dis = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (copyMap[i][j] == 1 || copyMap[i][j] == -1) {
                    int distance = Math.abs(N - i) + Math.abs(k - j);
                    if (dis > distance && distance <= D) {
                        dis = distance;
                        e[0] = i;
                        e[1] = j;
                    }
                }
            }
        }
        if (dis != Integer.MAX_VALUE) copyMap[e[0]][e[1]] = -1;
    }
}