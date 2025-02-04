import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

import static java.lang.System.in;

class Main {
    static int N, K;
    static Integer[] arr;
    static int max = Integer.MIN_VALUE;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        len = String.valueOf(N).length();
        K = Integer.parseInt(st.nextToken());
        arr = new Integer[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        DFS(0, "");
        System.out.println(max);
    }

    private static void DFS(int depth, String str) {
        if (depth == len) {
            if (!Objects.equals(str, "") && N >= Integer.parseInt(str)) {
                max = Math.max(max, Integer.parseInt(str));
            }
            return;
        }
        for (int i = 0; i < K; i++) {
            DFS(depth + 1, str + arr[i]);
            DFS(depth + 1, str);
        }
    }
}