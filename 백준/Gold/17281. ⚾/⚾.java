import org.w3c.dom.xpath.XPathResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N;
    static boolean[] visited;
    static int[] select;

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][10];
        select = new int[10];
        visited = new boolean[10];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[4] = true;
        select[4] = 1;
        answer = 0;

        DFS(2);
        System.out.println(answer);

    }

    private static void DFS(int num) {
        if (num == 10) {
            game();
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select[i] = num;
                DFS(num + 1);
                visited[i] = false;
            }
        }
    }

    private static void game() {
        int startPlayer = 1;
        boolean[] base;
        int score = 0;

        for (int i = 1; i <= N; i++) {
            base = new boolean[4];
            int out = 0;
            outer: while (true) {
                for (int j = startPlayer; j <= 9; j++) {
                    int hitter = map[i][select[j]];
                    if (hitter == 0) {
                        out++;
                    } else if (hitter == 1) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                if (k == 3) {
                                    score++;
                                    base[k] = false;
                                    continue;
                                }
                                base[k] = false;
                                base[k + 1] = true;
                            }
                        }
                        base[1] = true;

                    } else if (hitter == 2) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                if (k == 3 || k == 2) {
                                    score++;
                                    base[k] = false;
                                    continue;
                                }
                                base[k] = false;
                                base[k + 2] = true;
                            }
                        }
                        base[2] = true;
                    } else if (hitter == 3) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                score++;
                                base[k] = false;
                            }
                        }
                        base[3] = true;
                    } else if (hitter == 4) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                score++;
                                base[k] = false;
                            }
                        }
                        score++;
                    }
                    if (out == 3) {
                        startPlayer = j + 1;
                        if (startPlayer == 10) {
                            startPlayer = 1;
                        }
                        break outer;
                    }
                }
                startPlayer = 1;
            }
        }

        answer = Math.max(answer, score);


    }

}