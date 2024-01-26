import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;

    static List<Fireball>[][] map;
    static List<Fireball> fireballs;


    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        fireballs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            Fireball fireball = new Fireball(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            fireballs.add(fireball);
        }

        for (int i = 0; i < K; i++) {
            move();
            split();
        }
        int answer = 0;
        for (Fireball fireball : fireballs) {
            answer += fireball.m;
        }
        System.out.println(answer);
    }

    private static void split() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].size() < 2) {
                    map[r][c].clear();
                    continue;
                }

                if (map[r][c].size() >= 2) {
                    int mSum = 0;
                    int sSum = 0;
                    int size = map[r][c].size();
                    int even = 0;
                    int odd = 0;

                    for (Fireball cur : map[r][c]) {
                        mSum += cur.m;
                        sSum += cur.s;
                        if (cur.d % 2 == 0) {
                            even++;
                        } else {
                            odd++;
                        }
                        fireballs.remove(cur);
                    }
                    map[r][c].clear();
                    mSum /= 5;
                    if (mSum == 0) {
                        continue;
                    }
                    sSum /= size;

                    if (even == size || odd == size) {
                        fireballs.add(new Fireball(r, c, mSum, sSum, 0));
                        fireballs.add(new Fireball(r, c, mSum, sSum, 2));
                        fireballs.add(new Fireball(r, c, mSum, sSum, 4));
                        fireballs.add(new Fireball(r, c, mSum, sSum, 6));
                    } else {
                        fireballs.add(new Fireball(r, c, mSum, sSum, 1));
                        fireballs.add(new Fireball(r, c, mSum, sSum, 3));
                        fireballs.add(new Fireball(r, c, mSum, sSum, 5));
                        fireballs.add(new Fireball(r, c, mSum, sSum, 7));
                    }
                }
            }
        }

    }

    private static void move() {
        for (Fireball cur : fireballs) {
            int r = cur.r;
            int c = cur.c;
            int d = cur.d;
            int s = cur.s;

            int nx = (r + N + dx[d] * (s % N)) % N;
            int ny = (c + N + dy[d] * (s % N)) % N;
            cur.r = nx;
            cur.c = ny;
            map[cur.r][cur.c].add(cur);
        }
    }

    static class Fireball {
        public int r; //행
        public int c; //열
        public int m; //질량
        public int s; // 속력
        public int d; // 방향

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}