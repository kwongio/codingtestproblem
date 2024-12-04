import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, W, T;
    static List<int[]> list;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list.add(new int[]{s, e, t});
                list.add(new int[]{e, s, t});
            }

            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list.add(new int[]{s, e, -t});
            }

            if (getDistance()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean getDistance() {
        dis = new int[N + 1];
        Arrays.fill(dis, 99999999);
        dis[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < list.size(); j++) {
                int[] next = list.get(j);
                int cur = next[0];
                int nx = next[1];
                int cost = next[2];

                if (dis[nx] > dis[cur] + cost) {
                    dis[nx] = dis[cur] + cost;
                    if (i == N) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}