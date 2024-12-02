import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int maxH = 0;
        int maxL = 0;
        int maxWidth = 0;

        int[] arr = new int[1001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            if (maxH <= h) {
                maxH = h;
                maxL = l;
            }
            maxWidth = Math.max(l, maxWidth);
        }

        int[] frontPrefix = new int[maxWidth + 2];
        int[] backPrefix = new int[maxWidth + 2];

        int h = 0;
        for (int i = 0; i <= maxL; i++) {
            h = Math.max(h, arr[i]);
            frontPrefix[i + 1] = frontPrefix[i] + h;
        }

        h = 0;
        for (int i = maxWidth; i > maxL; i--) {
            h = Math.max(h, arr[i]);
            backPrefix[i] = backPrefix[i + 1] + h;
        }

        System.out.println(Arrays.stream(backPrefix).max().getAsInt() + Arrays.stream(frontPrefix).max().getAsInt());
    }
}
