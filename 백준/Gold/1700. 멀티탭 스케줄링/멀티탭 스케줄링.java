import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[] arr;
    static int N;
    static int K;
    static boolean[] visit;
    static int cnt;

    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        visit = new boolean[104];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            int input = arr[i];
            if (!visit[input]) {
                if (q.size() == N) {
                    int removeIdx = 0;
                    int value = 0;
                    for (int v : q) {
                        int remove = Integer.MAX_VALUE;
                        for (int j = i + 1; j < K; j++) {
                            if (v == arr[j]) {
                                remove = j;
                                break;
                            }
                        }
                        if (removeIdx < remove) {
                            removeIdx = remove;
                            value = v;
                        }
                    }
                    visit[value] = false;
                    cnt++;
                    q.remove(value);
                }
                visit[input] = true;
                q.add(input);
            }
        }
        System.out.println(cnt);

    }
}