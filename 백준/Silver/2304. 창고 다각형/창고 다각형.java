import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new int[]{l, h});
            maxH = Math.max(maxH, h);
        }
        Collections.sort(list, Comparator.comparing(o -> o[0]));

        int sum = 0;
        for (int i = 1; i <= maxH; i++) {
            int s = 0;
            int e = 0;

            for (int[] cur : list) {
                int l = cur[0];
                int h = cur[1];
                if (i <= h) {
                    s = l;
                    break;
                }
            }

            for (int[] cur : list) {
                int l = cur[0];
                int h = cur[1];
                if (i <= h) {
                    e = l + 1;
                }
            }
            sum += e - s;
        }
        System.out.println(sum);
    }
}