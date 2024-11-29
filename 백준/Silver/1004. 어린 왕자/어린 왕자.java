import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int c1 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int distance = getDistance(x1, c1, y1, c2);
                int distance1 = getDistance(x2, c1, y2, c2);
                int rr = r * r;
                if ((distance < rr && distance1 >= rr) || (distance >= rr && distance1 < rr)) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static int getDistance(int x1, int x2, int y1, int y2) {
        return (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}