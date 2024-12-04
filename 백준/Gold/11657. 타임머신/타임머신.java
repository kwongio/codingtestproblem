import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<long[]> list;
    static long[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (long j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            list.add(new long[]{a, b, c});
        }
        boolean distance = getDistance();
        if(distance){
            System.out.println("-1");
        }else{
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < N + 1; i++) {
                if (dis[i] == Long.MAX_VALUE) {
                    sb.append("-1");
                }else{
                    sb.append(dis[i]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }

    private static boolean getDistance() {
        dis = new long[N + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;
        for (long i = 1; i <= N; i++) {
            for (long[] next : list) {
                int cur = (int)next[0];
                int nx = (int)next[1];
                long cost = next[2];
                if (dis[cur] != Long.MAX_VALUE && dis[nx] > dis[cur] + cost) {
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
